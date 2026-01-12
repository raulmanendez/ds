package start.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {

	static void find(int arr[]) {
		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {

			if (i > 0 && arr[i - 1] == arr[i]) {
				continue;
			}

			searchPair(-arr[i], i + 1, arr, result);

		}

		System.out.println(result);
	}

	static void searchPair(int target, int start, int arr[], List<List<Integer>> result) {

		int end = arr.length - 1;
		while (start < end) {

			int sum = arr[start] + arr[end];
			if (sum == target) {
				result.add(List.of(-target, arr[start], arr[end]));
				start++;
				end--;

				while (start < end && arr[start - 1] == arr[start]) {
					start++;
				}

				while (start < end && arr[end + 1] == arr[end]) {
					end--;
				}

			} else if (sum > target) {
				end--;
			} else {
				start++;
			}
		}

	}

	public static void main(String[] args) {

		TripletSum.find(new int[] {-3, 0, 1, 2, -1, 1, -2});
	}
}
