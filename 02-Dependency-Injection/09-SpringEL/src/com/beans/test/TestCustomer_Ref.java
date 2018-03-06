package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Customer_Reference;

public class TestCustomer_Ref {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer_Reference cust = (Customer_Reference) context.getBean("cust_ref");
		
		System.out.println(cust);
	}

}
