package com.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookDAO;

public class TestBookDAO_CacheManager {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("connection_new.xml");
		
		BookDAO bookDAO = (BookDAO)context.getBean("bookDAO_cacheManager");
		long ISBN = 97815674L;
		// Get book by 97815674L id with twice
		System.out.println(bookDAO.getBook(ISBN));
		System.out.println(bookDAO.getBook(ISBN));
		
		// Update book
		bookDAO.updateBook(ISBN, 12345);
		
		// After update
		System.out.println(bookDAO.getBook(ISBN));
	}

}
