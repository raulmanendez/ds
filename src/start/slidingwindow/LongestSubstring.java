package start.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	// not more than k
	int longest(String s, int k) {

		int start=0, maxk=0;
		
		Map<Character, Integer> map=new HashMap<>();
		for(int end=0;end<s.length();end++) {
			char endChar = s.charAt(end);
			
			map.put(endChar, map.getOrDefault(endChar, 0)+1);
			
			System.out.println("map="+map);
			while(map.size() >  k) {
				char startChar = s.charAt(start);
				map.put(startChar, map.get(startChar)-1);
				
				if(map.get(startChar)==0) {
					map.remove(startChar);
				}
			
				start++;
				System.out.println("start="+start+" end="+end);
			}
			
			System.out.println("maxk="+maxk+" currentMax:"+(end - start + 1));
			maxk = Math.max(maxk, end - start + 1);
		}

		return maxk;
	}

	public static void main(String[] args) {

		System.out.println(new LongestSubstring().longest("aabbbcddefghghhi", 2));

	}
}
