package start.twopointers;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

	
	List<Integer> sum(int arr[], int targetSum) {
		List<Integer> result = new ArrayList<>();	
		
		int start=0, end=arr.length-1;
		
		while(start < end) {
			
			int sum = arr[start] + arr[end];
			
			if(sum==targetSum) {
				result.add(start);
				result.add(end);
			}
			
			if(sum > targetSum) {
				end--;
			} else {
				start++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		var twoSum = new TwoSum();
		System.out.println(
				twoSum.sum(new int[] {1,2,3,4,6}, 6)
				);
		
		System.out.println(
				twoSum.sum(new int[] {2, 5, 9, 11}, 11)
						);
		
		
	}
	
}
