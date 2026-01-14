package start.twopointers;

import java.util.ArrayList;
import java.util.List;

public class ProductLessThan {
	static List<List<Integer>> lessThan(int arr[], int target) {

		int product = 1, left = 0;
		List<List<Integer>> result = new ArrayList<>();
		for (int right = 0; right < arr.length; right++) {
			product *= arr[right];

			// shrink the window
			while (product >= target && left < arr.length) {
				product /= arr[left];
				left++;
			}

			var nestedList = new ArrayList<Integer>();
			for (int i = right; i >= left; i--) {
				nestedList.add(arr[i]);
				result.add(new ArrayList<>(nestedList));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(ProductLessThan.lessThan(new int[] { 2, 5, 3, 10 }, 30));
	}
}
