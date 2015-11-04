package com.inheritance;

public class Circle extends GeometricShapes{		
	double radius;
	
	Circle(double radius){
		super(radius);
		this.radius = radius;		
	}
	
	
	public double circumference(){
		return 2 * Math.PI * radius;
	}


	
	
	

}
