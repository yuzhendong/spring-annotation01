package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.aop.service.MathCalculator;
import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.bean.Red;
import com.atguigu.config.MainConfigOfAOP;
import com.atguigu.config.MainConifgOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.ext.ExtConfig;
import com.atguigu.ext.MyBeanDefinitionRegistryPostProcessor;
import com.atguigu.service.BookService;

public class IOCTest_Ext {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);
		
		
		//�����¼���
		applicationContext.publishEvent(new ApplicationEvent(new String("�ҷ�����ʱ��")) {
		}); 
		MyBeanDefinitionRegistryPostProcessor bean = applicationContext.getBean(MyBeanDefinitionRegistryPostProcessor.class);
		System.out.println(bean);
		applicationContext.close();
	}

}
