package start.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Averages {

	List<Integer> averages(int arr[], int k) {
		List<Integer> result = new ArrayList<>();
		int left=0;
		
		int sum=0;
		for(int right=0;right< arr.length;right++) {
			sum+=arr[right];
			
			if(right>=k-1) {
				result.add(sum/k);
				sum-=arr[left];
				left++;
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(
		new Averages().averages(new int[] {1,2,3,4,5}, 2)
				);
	}
}
