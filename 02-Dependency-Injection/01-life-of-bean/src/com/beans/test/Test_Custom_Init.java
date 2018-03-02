package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car_Custom_Init;

public class Test_Custom_Init {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_lifecycle_xml.xml");
		// To elegant shut down shut down the container
		((AbstractApplicationContext)context).registerShutdownHook();
		
		Car_Custom_Init car = context.getBean("car_custom_init", Car_Custom_Init.class);
		System.out.println(car);
	}

}
