package start.twopointers;

import java.util.Arrays;

public class TripletWithSmallerSum {

	static int total(int arr[], int target) {
		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < arr.length - 2; i++) {

			int start = i + 1;
			int end = arr.length - 1;

			while (start < end) {
				int sum = arr[i] + arr[start] + arr[end];
				if (sum < target) {
					result += (end - start);
					start++;
				}

				else {
					end--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(TripletWithSmallerSum.total(new int[] { -1, 0, 2, 3 }, 3));
	}
}
