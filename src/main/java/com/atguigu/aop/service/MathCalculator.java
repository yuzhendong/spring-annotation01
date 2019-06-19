package com.atguigu.aop.service;

public class MathCalculator {
	
	public int div(int i,int j){
		System.out.println("MathCalculator...div...");
		return i/j;	
	}
	public int sum(int i,int j){
		System.out.println("MathCalculator...sum...");
		return i+j;	
	}
}
