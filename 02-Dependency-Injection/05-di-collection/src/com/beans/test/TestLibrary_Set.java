package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Library_Set;

public class TestLibrary_Set {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Library_Set set = (Library_Set)context.getBean("library_set");
		
		set.displayBooks();
		System.out.println(set.getBooks().size());
	}

}
