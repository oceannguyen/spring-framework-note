package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car;

public class TestCarConstructorDI {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Car car = context.getBean("car_constructor_di", Car.class);
		System.out.println(car);
	}
}
