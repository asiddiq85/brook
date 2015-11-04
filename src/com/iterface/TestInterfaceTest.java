package com.iterface;


public class TestInterfaceTest {

	public static void main(String[] args) {
		Circle c = new Circle(2.0);
		Rectangle r = new Rectangle(2.0,  3.0);
		Rectangle r1 = new Rectangle(4.0,  6.0);
			
		getSumOfTwoCircle(c, r);						
		getSumOfTwoCircle(r, r1);
		getSumOfTwoCircle(c, c);
		
		getSumOfTwoCircle(r1, c);
		
		if(getSumOfTwoCircle(r1, c) > 89.0){
			System.out.println("We have a big number");
			
		}else{
			
			// do some other stuff
		}
		System.out.println(getSumOfTwoCircle(r1, c));
		
		
		
		System.out.println(c.getArea());
		c.extraMethod();
				
//		GeometriShapes gs = new Circle(2.0);
//		//((Circle) gs).extraMethod();
//		gs.getArea();
//		
//		GeometriShapes gs1 = new Rectangle(2.0, 3.0);
//		
//		gs1.getArea();
//		
//								
		
	}	
	
	public static double getSumOfTwoCircle(GeometriShapes gs1, GeometriShapes gs2){
		
		double i = gs1.getArea();
		double j = gs2.getArea();		
		System.out.println(i + j);
		return i + j;
		
	}
	

}
