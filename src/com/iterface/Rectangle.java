package com.iterface;

public class Rectangle implements GeometriShapes {
	
	double height;
	double width;
	
	double base;
	
	public Rectangle(double height, double width) {
		this.width = width;
		this.height = height;
	}
	@Override
	public double getArea() {
		double area = width * height;
		//System.out.println("rectangle area is: " + area);
		return area;		
	}

	@Override
	public double getPerimeter() {
		return 2 * height * width;
	}
	
	public void extraMethod(){
		System.out.println("this is an extra method in Rectangle class");
	}

	

}
