package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.beans.Book;

@Repository("bookDAO_sessionFactory")
public class BookDAO_SessionFactory implements BookDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public BookDAO_SessionFactory(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int addBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			
			session.saveOrUpdate(book);
			transaction.commit();
			session.close();

			return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBook(long ISBN, int price) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			
			Book book = session.get(Book.class, ISBN);
			book.setPrice(price);
			session.saveOrUpdate(book);
			transaction.commit();
			session.close();
			
			return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		Session session = sessionFactory.openSession(); 
	    Transaction transaction = session.beginTransaction(); 
	    try {
	    	
			Book book = session.get(Book.class, ISBN);
			session.delete(book);
			transaction.commit();
			session.close();
			
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

}
