package com.stereotype.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomer_Component {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer_Component customer = (Customer_Component) context.getBean("customer_Component");
		
		System.out.println(customer);

	}
}
