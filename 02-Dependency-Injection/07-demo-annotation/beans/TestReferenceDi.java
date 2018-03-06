package com.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestReferenceDi {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		System.out.println("Dependency Injection by Setter");
		Customer cust1 = context.getBean("cust_setter_di", Customer.class);
		System.out.println(cust1);
		
		System.out.println("Dependency Injection by Contrustor");
		Customer cust2 = context.getBean("cust_constuctor_di", Customer.class);
		System.out.println(cust2);
	}

}
