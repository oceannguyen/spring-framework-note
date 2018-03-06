package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Library_List;

public class TestLibrary_List {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Library_List list = (Library_List) context.getBean("library_list");
		
		list.displayBooks();
		System.out.println(list.getBooks().size());
	}
}
