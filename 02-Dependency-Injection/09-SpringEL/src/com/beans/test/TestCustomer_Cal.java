package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Customer;

public class TestCustomer_Cal {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer cust = (Customer) context.getBean("cust_calculation");
		
		System.out.println(cust);
	}

}
