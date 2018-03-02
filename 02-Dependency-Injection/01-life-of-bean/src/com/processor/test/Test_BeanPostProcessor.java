package com.processor.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.processor.Demo_BeanPostProcessor;

public class Test_BeanPostProcessor {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_lifecycle_xml.xml");
		// To elegant shut down shut down the container
		((AbstractApplicationContext)context).registerShutdownHook();
		
		Demo_BeanPostProcessor obj = context.getBean("beanPostProcessor", Demo_BeanPostProcessor.class);
		System.out.println(obj);
	}
}
