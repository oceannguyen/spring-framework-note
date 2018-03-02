package com.contextAware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.beans.Car_API_Init;

public class MyBean implements ApplicationContextAware {
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Context set");
		this.context = ctx;
	}

	public void display() {
		System.out.println(context.getBean("car_api_init", Car_API_Init.class));
	}
}
