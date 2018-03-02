package com.contextAware.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contextAware.MyBean;

public class Test_MyBean {
	
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_lifecycle_xml.xml");
		// To elegant shut down shut down the container
		((AbstractApplicationContext)context).registerShutdownHook();
		
		MyBean myBean = context.getBean("myBean", MyBean.class);
		myBean.display();
	}
}
