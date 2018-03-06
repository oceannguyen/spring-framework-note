package com.beans.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.EnggStudent;
import com.beans.Student;

public class TestStudent {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		EnggStudent student_old = (EnggStudent) context.getBean("engg_old");
		System.out.println("with old configuration");
		System.out.println(student_old);

		EnggStudent student_new = (EnggStudent) context.getBean("engg_new");
		System.out.println("with new configuration");
		System.out.println(student_new);

		System.out.println("with new configuration with overridding roll number");
		EnggStudent student_new1 = (EnggStudent) context.getBean("engg_new1");
		System.out.println(student_new1);

		System.out.println("try to obtain Student instance");
		Student student = (Student) context.getBean("student");
	}

}
