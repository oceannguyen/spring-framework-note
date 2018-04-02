package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Customer;

public class TestMyConfiguration {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer customer = context.getBean("myCustomer", Customer.class);
		
		System.out.println(customer);
	}

}
