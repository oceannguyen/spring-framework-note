package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Customer_Reference;

public class TestCustomer_Ref1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer_Reference cust = (Customer_Reference) context.getBean("cust_ref_new");
		
		System.out.println(cust);
	}

}
