package com.iterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestInterface {

	public static void main(String[] args) {

		List<String> list  = new ArrayList<String>();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(24089);
		arr.add(2435);
		
		list.add("dhad");
		
		list.add("483758");
		
		list.add("abc");
		list.add("ed");
		list.add("wretgr");
		list.add("rwetgrh");
		
		System.out.println(list.size());
		
		for( Object i : list ){
			System.out.println(i);
		}
		
		
		Map<Character, String> hashMap = new HashMap<Character, String>();  
		
		hashMap.put('c', "cAt");
		hashMap.put('d', "Dawg");
		hashMap.put('e', "elephant");
		hashMap.put('f', "frog");
		hashMap.put('g', "goat");
		hashMap.put('h', "hawk");
		
		System.out.println("Keys of the hash map are: "+ hashMap.keySet());
		System.out.println("The values are: " + hashMap.values());
		
		hashMap.containsKey("t");
		
		System.out.println(hashMap.get('e'));
		
		
		
		
		
		
		
		/*
		 * add the area of 2 objects: could be both circle or both rectangle or the combination of each;
		 * to do this we will need 4 different methods:
		 * 1. public static double sumOfArea(Circle c1, Circle c2)
		 * 2. public static double sumOfArea(Rectangle r1, Rectangle r2)
		 * 3. public static double sumOfArea(Circle c, Rectangle r)
		 * 4. public static double sumOfArea(Rectangle r, Circle c)
		 * is it a good idea? is there a better way to do this? 
		 */
		GeometriShapes gs = new Circle(4.0);
			
		System.out.println(gs.getArea());
		
		Circle c = new Circle(5.0);
		Rectangle r = new Rectangle(9.0, 6.0);
		r.base = 49.0;
		
		((Circle) gs).extraMethod();
		
		
		Circle c1 = (Circle) gs; // type casting -- creating an object of circle class but it's
		// changing gs to a circle object
		c1.extraMethod();

		System.out.println("the sum of two area is: " + sumOfArea(c, r));
	}
	
	public static double sumOfAreaOfCircleAndRectangle(Circle c, Rectangle r){
		return c.getArea() + r.getArea();		
	}
	
	public static double sumOfAreaofRectangles(Rectangle r1, Rectangle r2){
		return r1.getArea() + r2.getArea();
	}
	
	public static double sumOfArea(Circle c, Circle c1){
		return c.getArea() + c1.getArea();
	}	
	
	public static double sumOfAreaOfRectangleAndCircle(Rectangle r, Circle c){
		System.out.println(r.getArea());
		System.out.println(c.getArea());
		return r.getArea() + c.getArea();
		
	}
	
	public static double sumOfArea(GeometriShapes gs1, GeometriShapes gs2){
		return gs1.getArea() + gs2.getArea();
	}

}
