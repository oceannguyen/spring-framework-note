package com.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Book;
import com.dao.BookDAO;

public class TestBookDAO {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("connection.xml");
		BookDAO bookDAO = (BookDAO) context.getBean("bookDao");
		
		int rows=bookDAO.addBook(new Book("Learning Modular Java Programming", 9781234L,"PacktPub publication",800,"explore the power of Modular programming","T.M.Jog"));
	    if(rows>0)
	    {
	    	System.out.println("book inserted successfully");
	    }
	    else
	    	System.out.println("SORRY!cannot add book");
	}

}
