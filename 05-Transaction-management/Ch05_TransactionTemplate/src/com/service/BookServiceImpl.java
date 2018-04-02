package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.beans.Book;
import com.dao.BookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	private final TransactionTemplate transactionTemplate;

	private final BookDAO bookDAO;
	
	@Autowired
	public BookServiceImpl(TransactionTemplate transactionTemplate, BookDAO bookDAO) {
		super();
		this.transactionTemplate = transactionTemplate;
		this.bookDAO = bookDAO;
	}

	@Override
	public Book searchBook(long ISBN) {
		
		transactionTemplate.setReadOnly(true);
		
		return transactionTemplate.execute(new TransactionCallback<Book>(){

			@Override
			public Book doInTransaction(TransactionStatus status) {
				Book book = bookDAO.searchBook(ISBN);
				
				return book;
			}
			
		});
		
	}

	@Override
	public boolean addBook(Book book) {
		
		transactionTemplate.setReadOnly(false);
		
		return transactionTemplate.execute(new TransactionCallback<Boolean>(){

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				
				try {
					int rows = bookDAO.addBook(book);
					if(rows > 0) {
						return true;
					}
				} catch (Exception e) {
					status.setRollbackOnly();
				}
				
				return false;
			}
			
		});
		
	}

	@Override
	public boolean updateBook(long ISBN, int price) {
		
		transactionTemplate.setReadOnly(false);
		
		if(searchBook(ISBN) != null) {

			return transactionTemplate.execute(new TransactionCallback<Boolean>() {

				@Override
				public Boolean doInTransaction(TransactionStatus status) {
					
					try {
						int rows = bookDAO.updateBook(ISBN, price);
						if(rows > 0) {
							return true;
						}
					} catch (Exception e) {
						status.setRollbackOnly();
					}
					
					return false;
				}
				
			});
		}
		
		return false;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		
		transactionTemplate.setReadOnly(false);
		
		if(searchBook(ISBN) != null) {
			
			transactionTemplate.execute(new TransactionCallback<Boolean>() {

				@Override
				public Boolean doInTransaction(TransactionStatus status) {
					try {
						boolean deleted = bookDAO.deleteBook(ISBN);
						if(deleted) {
							return true;
						}
					} catch (Exception e) {
						status.setRollbackOnly();
					}
					return false;
				}
				
			});
		}
		return false;
	}

}
