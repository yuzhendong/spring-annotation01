package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ���ô���������ʼ��ǰ����д�����
 * �����ô��������뵽������
 * @author lfy
 */
@Scope("prototype")
@Component()
public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
	
		// TODO Auto-generated constructor stub
		System.out.println("--->init MyBeanPostProcessor"+this.getClass().getName());
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
		return bean;
	}

}
