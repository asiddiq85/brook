package intermediate.java.concepts;

import java.util.ArrayList;
import java.util.List;

public class Fibbonacci {

	public static void main(String[] args) {
		
		
		
		
//		System.out.println(fibb(1));
		System.out.println(fibbonaci(2));
		System.out.println(fibbonaci(10));

	}
	
	static List<Integer> fibb(int i){
		List<Integer> list = new ArrayList<>();
		
		if(i == 1 || i ==2 ){
			list.add(1);
			list.add(1);
		}else{	
			int a = 1;
			int b = 1;
			int k  = 0;
			list.add(1);
			list.add(1);
			while(k < i){
				int c = a + b;
				list.add(c);
				
				a = b;
				
				b = c;
				
				k ++;
			}
											
		}
		return list;
		
								
	}

	
	static int fibbonaci(int howMany){
		if (howMany == 1 || howMany == 2){
			return 1;
		}
		return fibbonaci(howMany -1 ) + fibbonaci(howMany - 2);
	}
}
