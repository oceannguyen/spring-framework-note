package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car_JSR;

public class Test_Car_JSR {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_lifecycle_jsr.xml");
		// To elegant shut down shut down the container
		((AbstractApplicationContext)context).registerShutdownHook();
		
		Car_JSR car = context.getBean("car_jsr", Car_JSR.class);
		System.out.println(car);
	}

}
