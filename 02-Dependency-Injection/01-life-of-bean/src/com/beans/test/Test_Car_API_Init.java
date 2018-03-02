package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car_API_Init;

public class Test_Car_API_Init {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_lifecycle_xml.xml");
		// To elegant shut down shut down the container
		((AbstractApplicationContext)context).registerShutdownHook();
		
		Car_API_Init car = context.getBean("car_api_init", Car_API_Init.class);
		System.out.println(car);
	}

}
