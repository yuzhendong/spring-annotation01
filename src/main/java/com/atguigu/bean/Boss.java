package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
//Ĭ�ϼ���ioc�����е��������������������޲ι��������������ٽ��г�ʼ����ֵ�Ȳ���
@Component
public class Boss {
	
	
	private Car car;
	
	public Boss() {
		System.out.println("Boss...�޲ι�����");
		// TODO Auto-generated constructor stub
	}



	//������Ҫ�õ���������Ǵ������л�ȡ
	//@Autowired
	public Boss(Car car){
		this.car = car;
		System.out.println("Boss...�вι�����");
	}
	
	

	public Car getCar() {
		return car;
	}


	@Autowired 
	//��ע�ڷ�����Spring����������ǰ���󣬾ͻ���÷�������ɸ�ֵ��
	//����ʹ�õĲ������Զ������͵�ֵ��ioc�����л�ȡ
	public void setCar(Car car) {
		this.car = car;
	}



	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
	

}
