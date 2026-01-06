package start.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringAfterReplacement {

	int longest(String s,int k) {
		Map<Character, Integer> fm=new HashMap<>();
		
		
		int start=0, maximumFrequency = 0, maxLength = 0;
		for(int end=0;end<s.length();end++) {
			char endChar = s.charAt(end);
			
			fm.put(endChar, fm.getOrDefault(end, 0)+1);
			
			maximumFrequency = Math.max(maximumFrequency, fm.get(endChar));
			
			if(end - start + 1 - maximumFrequency > k) {
				char startChar = s.charAt(start);
				
				fm.put(startChar, fm.getOrDefault(start, 0)-1);
				start++;
			}
			
			maxLength = Math.max(maxLength, end - start + 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		
		System.out.println(
		new LongestSubStringAfterReplacement().longest("aabccbb", 2)
				);
		
	}
}
