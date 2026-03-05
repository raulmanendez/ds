package start.random;

import java.util.HashSet;

public class ContinuousSequenceLength {

	static int length(int arr[]) {

		var set= new HashSet<Integer>();
		for(int num:arr) {
			set.add(num);
		}
		
		int maxSequenceLength = 0;
		for(int num:arr) {
			
			if(!set.contains(num-1)) {
				
				int currentNum = num;
				int currentSequenceLength = 1;
				
				while(set.contains(currentNum + 1)) {
					currentNum++;
					currentSequenceLength++;
				}
				
				maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
				
			}
			
		}
		
		
		return maxSequenceLength;
	}

	public static void main(String[] args) {

		System.out.println(length(new int[] { 100, 1, 200, 4, 6, 3, 89, 2 }));//4 - 4-3-2-1
	}
}
