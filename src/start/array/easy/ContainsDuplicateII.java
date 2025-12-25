package start.array.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k == 0) return false;

		Set<Integer> set=new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if(set.contains(nums[i])) return true;
			if(i >= k) set.remove(nums[i-k]);

			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
//		int arr[] = new int[] { 99,99 };
//		System.out.println(containsNearbyDuplicate(arr, 2));

//		int arr[] = new int[] { 1,0,1,1 };
//		System.out.println(containsNearbyDuplicate(arr, 1));

		int arr[] = new int[] { 1,2,3,1,2,3 };
		System.out.println(containsNearbyDuplicate(arr, 2));
	}
}
