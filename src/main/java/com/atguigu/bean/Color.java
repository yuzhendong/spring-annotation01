package com.atguigu.bean;

public class Color {
	
	private Car car;

	public Color() {
		System.out.println("Color constructor...");
		//super();
		// TODO Auto-generated constructor stub
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Color [car=" + car + "]";
	}
	
	

}
