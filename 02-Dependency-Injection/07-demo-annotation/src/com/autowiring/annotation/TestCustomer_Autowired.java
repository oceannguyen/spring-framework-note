package com.autowiring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomer_Autowired {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer_Autowired customer = context.getBean("customer_Autowired", Customer_Autowired.class);
		
		System.out.println(customer);
	}

}
