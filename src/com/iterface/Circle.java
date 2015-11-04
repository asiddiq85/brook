package com.iterface;

public class Circle implements GeometriShapes{
	
	
	double radius;  // instance variable -- global variable
	
	Circle(double radius){
		this.radius = radius;
	}

	@Override
	public double getArea(){
		// formula: pi r^2
			return Math.PI * Math.pow(radius, 2);		
	}

	@Override
	public double getPerimeter() {
		return Math.PI * radius * 2; // 2*PI*r		
	}

	public void extraMethod(){
		System.out.println("Circle's extra method");
	}
	
	
	

}
