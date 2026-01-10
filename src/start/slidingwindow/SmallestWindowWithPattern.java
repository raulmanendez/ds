package start.slidingwindow;

import java.util.Map;

import start.Util;

public class SmallestWindowWithPattern {

	String smallestWindow(String s, String pattern) {
		
		int start = 0, minLength = s.length() + 1, matched = 0, minStart=0;
		Map<Character, Integer> fm = Util.frequency(pattern);
		for(int end=0;end<s.length();end++) {
			char endChar = s.charAt(end);
			if(fm.containsKey(endChar)) {
				fm.put(endChar, fm.get(endChar) - 1);
				
				if(fm.get(endChar)>=0)
					matched ++;
			}
			
			//shrink
			while(matched == pattern.length()) {
				if(minLength > end - start + 1) {
					minLength =  end - start + 1;
					minStart = start;
				}
				
				char startChar = s.charAt(start);
				start++;
				if(fm.containsKey(startChar)) {
					
					if(fm.get(startChar)==0)
						matched --;
					
					fm.put(startChar, fm.get(startChar) + 1);
				}
			}
		}
		if(minLength > s.length()) return "--";
		
		return s.substring(minStart, minStart + minLength);
	}
	
	public static void main(String[] args) {
		var c = new SmallestWindowWithPattern();
		
		System.out.println(c.smallestWindow("aabdec", "abc"));
		System.out.println(c.smallestWindow("abdbca", "abc"));
		System.out.println(c.smallestWindow("adcad", "abc"));
		System.out.println(c.smallestWindow("adcad", "aad"));
	}
}
