package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.atguigu.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {
	
	@Test
	public void test01(){
		//1������ioc����
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("�����������...");
		
		//Object obj1=applicationContext.getBean("dog");
		//Object obj1=applicationContext.getBean("car");
	    Object obj1=applicationContext.getBean("myBeanPostProcessor");
	 //   Object obj2=applicationContext.getBean("MyBeanPostProcessor");
	    System.out.println(obj1);
		//�ر�����
		applicationContext.close();
	}

}
