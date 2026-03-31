package start.random;

import java.util.PriorityQueue;

import start.Util;

public class SortKSorted {

	static void sort(int nums[], int k) {
		var mh = new PriorityQueue<Integer>((a,b) -> a-b);
		
		for(int i=0;i<=k;i++) {
			mh.add(nums[i]);
		}
		
		int insertAt =0;
		for(int i=k+1;i< nums.length;i++) {
			nums[insertAt] = mh.poll();
			insertAt++;
			mh.add(nums[i]);
		}
		
		while(!mh.isEmpty()) {
			nums[insertAt] = mh.poll();
			insertAt++;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {5,1,9,4,7,10};
		sort(arr, 2);
		Util.print(arr);
	}
}
