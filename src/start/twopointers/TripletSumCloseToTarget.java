package start.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

	static int tripletSum(int arr[], int target) {

		Arrays.sort(arr);
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {

			int start = i + 1;
			int end = arr.length - 1;
			while (start < end) {
				int currentDiff = target - arr[i] - arr[start] - arr[end];

				if (currentDiff == 0) {
					return 0;
				}

				if (Math.abs(currentDiff) < Math.abs(smallest)) {
					smallest = currentDiff;
				}

				// assuming currentDiff = x and smallest = -x
				if (Math.abs(currentDiff) < Math.abs(smallest) ||
						(Math.abs(currentDiff) == Math.abs(smallest) && currentDiff > smallest)) {
					smallest = currentDiff;
				}
				//?

				if (currentDiff > 0) {
					start++;
				} else {
					end--;
				}
			}
		}

		return target - smallest;
	}

	public static void main(String[] args) {
		int result = TripletSumCloseToTarget.tripletSum(new int[] { -8, -3, 1, 4, 9 }, 6);

		System.out.println("result :>" + result);
	}

}
