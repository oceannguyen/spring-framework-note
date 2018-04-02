package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.beans.Book;
import com.dao.BookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService {

	private final PlatformTransactionManager transactionManager;

	private final BookDAO bookDAO;

	@Autowired
	public BookServiceImpl(PlatformTransactionManager transactionManager, BookDAO bookDAO) {
		super();
		this.transactionManager = transactionManager;
		this.bookDAO = bookDAO;
	}

	@Override
	public Book searchBook(long ISBN) {
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		// set transaction as read only
		((DefaultTransactionDefinition) definition).setReadOnly(true);
		
		Book book = bookDAO.searchBook(ISBN);
		
		return book;
	}

	@Override
	public boolean addBook(Book book) {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
		
		int rows = bookDAO.addBook(book);
		if (rows > 0) {
			transactionManager.commit(transactionStatus);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBook(long ISBN, int price) {
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
		
		if (searchBook(ISBN).getISBN() == ISBN) {
			int rows = bookDAO.updateBook(ISBN, price);
			if (rows > 0) {
				transactionManager.commit(transactionStatus);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
		
		if(searchBook(ISBN).getISBN() == ISBN) {
			boolean deleted = bookDAO.deleteBook(ISBN);
			if(deleted) {
				transactionManager.commit(transactionStatus);
				return true;
			}
		}
		return false;
	}

}
