package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Book;
import com.dao.BookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService {

	private final BookDAO bookDAO;

	@Autowired
	public BookServiceImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional(readOnly = true)
	public Book searchBook(long ISBN) {

		Book book = bookDAO.searchBook(ISBN);

		return book;

	}

	@Override
	@Transactional(readOnly = false)
	public boolean addBook(Book book) {

		try {
			int rows = bookDAO.addBook(book);
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean updateBook(long ISBN, int price) {

		try {
			int rows = bookDAO.updateBook(ISBN, price);
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteBook(long ISBN) {

		try {
			boolean deleted = bookDAO.deleteBook(ISBN);
			if (deleted) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
