package com.atguigu.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Scope("prototype")
//@Component
public class Car {
	
	public Car(){
		System.out.println("car constructor...");
	}
	
	public void init(){
		System.out.println("car ... init...");
	}
	
	public void detory(){
		System.out.println("car ... detory...");
	}

}
