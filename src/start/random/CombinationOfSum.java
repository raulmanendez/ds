package start.random;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfSum {

	static void sum(int nums[], int target) {
		List<List<Integer>> result = new ArrayList<>();

		sum(new ArrayList<>(), nums, 0, target, result);
		System.out.println(result);
	}

	static void sum(List<Integer> combination, int nums[], int startIndex, int target, List<List<Integer>> result) {

		if (target == 0) {
			result.add(new ArrayList<>(combination));
			return;
		}

		if (target < 0)
			return;

		for (int i = startIndex; i < nums.length; i++) {
			combination.add(nums[i]);
			sum(combination, nums, i, target - nums[i], result);

			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {

		sum(new int[] { 1, 2, 3 }, 4);
	}
}
