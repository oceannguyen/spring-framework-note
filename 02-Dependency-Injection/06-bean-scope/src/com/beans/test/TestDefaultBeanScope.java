package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car;

public class TestDefaultBeanScope {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Car car1 = context.getBean("car_default_scope", Car.class);
		Car car2 = context.getBean("car_default_scope", Car.class);
		
		car1.setColor("Pink");
		
		// car1 and car2 refer to the same object, because of singleton bean scope
		System.out.println(car1);
		System.out.println(car2);
	} 
}
