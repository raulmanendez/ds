package start.array.recurse;

import java.util.ArrayList;
import java.util.List;

public class MultiplyV2 {

	List<String> permutations(String str, int index) {
		if(index>=str.length()) return null;
		
		String first = str.substring(0, 2);
		String second = new StringBuilder(first).reverse().toString();
	
		List<String> list = new ArrayList<>();
		list.add(first);
		list.add(second);
		
		
		for(String s:list) {
			System.out.println(s+str.charAt(index));
			System.out.println(str.charAt(index)+s);
			
			permutations(str, index+1);
		}
		
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(
		new MultiplyV2().permutations("abcd", 2)
				);
				
	}
}
