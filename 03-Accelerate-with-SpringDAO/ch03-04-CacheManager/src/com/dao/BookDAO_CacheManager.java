package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.beans.Book;

@Repository("bookDAO_cacheManager")
public class BookDAO_CacheManager implements BookDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public BookDAO_CacheManager(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Cacheable("repo")
	public Book getBook(long ISBN) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Book book = null;

		try {
			book = session.get(Book.class, ISBN);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
