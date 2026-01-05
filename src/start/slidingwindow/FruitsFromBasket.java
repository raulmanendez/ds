package start.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsFromBasket {

	int maxFruits(char[] chars) {
		
		Map<Character, Integer> fm=new HashMap<>();
		
		int maxBasketSize =0,start=0;
		for(int end=0;end<chars.length;end++) {
			
			char endChar = chars[end];
			
			fm.put(endChar, fm.getOrDefault(endChar, 0)+1);
			
			while(fm.size()>2) {
				
				char startChar = chars[start];
				
				fm.replace(startChar, fm.getOrDefault(endChar, 0)-1);//b1
				
				if(fm.get(startChar)==0) {
					fm.remove(startChar);
				}
				start++;
			}
			
			maxBasketSize = Math.max(end - start + 1, maxBasketSize);
			
		}
		
		return maxBasketSize;
	}
	
	public static void main(String[] args) {
		System.out.println(
		new FruitsFromBasket().maxFruits(new char[] {'a','b','c','a','c'})
				);
	}
}
