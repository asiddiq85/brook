package webdriver.concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetMapArrayListHashTable {

	public static void main(String[] args) {

		Set<String> s = new HashSet<String>();  // cannot have duplicate values
		s.add("duke");
		s.add("438");
		s.add("438");
		s.add("efdg");
		s.add("duke");
		
		System.out.println("There are " +  s.size() + " items.");
		Iterator<String> iterator = s.iterator();
		while(iterator.hasNext()){
			String st = iterator.next();
			System.out.println(st);			
		}
		

		Map<String, String> map = new HashMap<String, String>(); // cannot have duplicate keys
		map.put("key", "This");
		map.put("key1", "world");
		map.put("key2", "is");
		map.put("key3", "full");
		map.put("key4", "of");
		
		map.put("key5", "crap!");
		
		for(String key: map.keySet()){
			System.out.println(key + ": " + map.get(key));
		}
		
		
		ArrayList<String> arrList = new ArrayList<String>();
		
		arrList.add("this");
		arrList.add("world");
		arrList.add("is");
		arrList.add("full");
		arrList.add("of");
		arrList.add("crappy");
		arrList.add("things!");
		StringBuilder strBuilder = new StringBuilder();
		
		for(int i =  0; i < arrList.size(); i ++  ){
//			System.out.println(arrList.get(i));
			strBuilder.append(arrList.get(i) + " ");			
		}
		System.out.println(strBuilder);
		
	}

}
