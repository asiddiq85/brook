package com.iterface;

public class Triangle implements GeometriShapes{

	double base, height;
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;		
	}
	@Override
	public double getArea() {
		return base * height * (1/2);
	}

	@Override
	public double getPerimeter() {
		
		return 0;
	}
	
	

}
