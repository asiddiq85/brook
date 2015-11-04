package com.inheritance;

public class GeometricShapes {
	
	private double radius;
	private double height;
	private double width;
	
	GeometricShapes (double height, double width){
		this.height = height;
		this.width = width;					
	}
	
	GeometricShapes(double radius){
		this.radius = radius;
	}
	
	public double getAraOfCircle(){
		return Math.PI * Math.pow(radius, 2); 
	}
	
	public double getAreaOfRectangle(){
		return height * width;		
	}
	
	
	public double getAreaOfTirangle(){
		double base = width;
		double area =  (.5) * height * base;
		System.out.println(area);
		return area;
		
	}
	
	
	
	
}
