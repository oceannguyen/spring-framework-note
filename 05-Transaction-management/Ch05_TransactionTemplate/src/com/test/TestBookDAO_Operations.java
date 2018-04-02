package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Book;
import com.service.BookService;

public class TestBookDAO_Operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("connection_new.xml");
		BookService service = (BookService) context.getBean("bookService");
		// add book
		boolean added = service.addBook(new Book("Java EE 7  Developer Handbook", 97815674L, "PacktPub publication",
				332, "explore the Java EE7  programming", "Peter pilgrim"));
		if (added) {
			System.out.println("book inserted successfully");
		} else
			System.out.println("SORRY!cannot add book");
		// update the book
		boolean updated = service.updateBook(97815674L, 800);
		if (updated) {
			System.out.println("book updated successfully");
		} else
			System.out.println("SORRY!cannot update book");
		// delete the book
		boolean deleted = service.deleteBook(97815674L);
		if (deleted) {
			System.out.println("book deleted successfully");
		} else
			System.out.println("SORRY!cannot delete book");
	}

}
