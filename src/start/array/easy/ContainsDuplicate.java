package start.array.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set=new HashSet<>();
		for(int x:nums) if(!set.add(x)) return true;
		return false;
	}

	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3,4,1};

		System.out.println(containsDuplicate(arr));

	}
}
