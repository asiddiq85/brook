package com.inheritance;

public class TestPolymorphism {

	public static void main(String[] args) {

		Circle c = new Circle(8.2);			
		System.out.println(c.getAraOfCircle());
		
		GeometricShapes gs = new GeometricShapes(3.0);
		
		System.out.println(c.circumference());
		
		
		
		
		
	}

}
