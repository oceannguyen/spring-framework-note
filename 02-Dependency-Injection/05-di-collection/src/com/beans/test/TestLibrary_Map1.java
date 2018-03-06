package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Library_Map1;

public class TestLibrary_Map1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Library_Map1 map1 = (Library_Map1) context.getBean("library_map1");

		map1.displayBooks();
	}

}
