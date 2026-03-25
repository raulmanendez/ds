package start.random;

import java.util.HashMap;

public class GeometricSequenceTriplets {

	static int count(int nums[], int r) {
		int count = 0;
		
		var leftMap = new HashMap<Integer,Integer>();
		var rightMap = new HashMap<Integer,Integer>();
		
		for(int num:nums) {
			rightMap.put(num, rightMap.getOrDefault(num, 0)+1);
		}
		
		for(int num:nums) {
			rightMap.put(num, rightMap.get(num)-1);
			
			if(num%r==0)
				count+=leftMap.getOrDefault(num/r, 0) * rightMap.getOrDefault(num*r, 0);
			
			leftMap.put(num, leftMap.getOrDefault(num, 0)+1);
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(count(new int[] { 2, 1, 2, 4, 8, 8 }, 2));
	}
}
