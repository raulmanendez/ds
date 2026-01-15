package start.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	static void sum(int arr[], int target) {

		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr.length - 3; i++) {

			for (int j = i + 1; j < arr.length - 2; j++) {

				int start = j + 1;
				int end = arr.length - 1;
				
				while (start < end) {
					int sum = arr[i] + arr[j] + arr[start] + arr[end];

					if (sum == target) {
						result.add(Arrays.asList(arr[i], arr[j], arr[start], arr[end]));
						start++;
						end--;

						while (start < end && arr[start - 1] == arr[start])
							start++;
						while (start < end && arr[end + 1] == arr[end])
							end--;

					} else if (sum > target) {
						end--;
					} else {
						start++;
					}
				}

			}

		}
		
		System.out.println(result);

	}

	public static void main(String[] args) {
		FourSum.sum(new int[] {4,1,2,-1,1,-3}, 1);
	}

}
