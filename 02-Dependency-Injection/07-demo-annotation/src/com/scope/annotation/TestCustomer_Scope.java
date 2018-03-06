package com.scope.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomer_Scope {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer_Scope cust1 = context.getBean("customer_Scope", Customer_Scope.class);
		Customer_Scope cust2 = context.getBean("customer_Scope", Customer_Scope.class);
		
		// change some values
		cust1.setCustId(11);
		cust2.setCustName("Nguyen Dai Duong");
		
		// view output
		System.out.println(cust1);
		System.out.println(cust2);
	}

}
