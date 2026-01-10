package start;

import java.util.HashMap;

public class Test {

	int test(int arr[], int targetSum) {

		int start = 0, sum = 0, minLength = arr.length;
		for (int end = 0; end < arr.length; end++) {
			sum += arr[end];

			while (sum >= targetSum) {
				minLength = Math.min(minLength, end - start + 1);
				System.out.println("sum:"+sum);
				sum -= arr[start];
				start++;
			}
		}

		return minLength;
	}

	
	//araaci 2 => 4
	
	int longest(String s, int k) {
		
		
		int start =0,max=0;
		
		var map = new HashMap<Character,Integer>();
		for(int end=0;end<s.length();end++) {
			
			char endChar = s.charAt(end);
			map.put(endChar, map.getOrDefault(endChar, 0) +1);
			
			if(map.size()>k) {
				
				char startChar = s.charAt(start);
				
				map.put(startChar, map.getOrDefault(startChar, 0) -1);
				
				if(map.get(startChar)==0)
					map.remove(startChar);
				
				start++;
			}
			
			System.out.println("end:"+end+" start:"+start+" max:"+max+" map"+map);
			max = Math.max(max, end - start + 1);
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test().longest("araaci", 1));
	}
}
