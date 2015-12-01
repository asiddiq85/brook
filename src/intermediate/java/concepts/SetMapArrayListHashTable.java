package intermediate.java.concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SetMapArrayListHashTable {

	public static void main(String[] args) {
		
		boolean b =  isPrime(45);
		System.out.println(b);

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
	
	
	
	
	public Map<Character, Integer> reverseString(String string){
		Map <Character, Integer> hash = new HashMap<Character, Integer>();
				
		String str = "When the winter leaves the Australians, the winter hits us.";
		
		char[] chArray = str.toCharArray();
		
		int counter = 1;
		
		for(Character ch : chArray){
			
			if(hash.containsKey(ch)){
				counter = counter +1;				
			}else{
				hash.put(ch, counter);
			}								
		}
		System.out.println(hash);
		return hash;
	}

	public static boolean isPrime(int number){
		for(int i=2; i<=number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
		
	}
}
