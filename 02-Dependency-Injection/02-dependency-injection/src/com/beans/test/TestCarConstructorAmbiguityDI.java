package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car;

public class TestCarConstructorAmbiguityDI {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Car car = context.getBean("car_constuctor_ambiguity", Car.class);
		System.out.println(car);
	}
}
