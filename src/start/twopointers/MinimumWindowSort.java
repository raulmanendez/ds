package start.twopointers;

public class MinimumWindowSort {

	static int window(int arr[]) {

		int low = 0;
		int high = arr.length - 1;

		// find the first number out of sorting order from the beginning
		while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
			low++;
		}

		if (low == arr.length - 1)// already sorted
			return 0;

		// find the first number out of sorting order from the end
		while (high > 0 && arr[high - 1] <= arr[high]) {
			high--;
		}

		int minInSubArray = Integer.MAX_VALUE;
		int maxInSubArray = Integer.MIN_VALUE;

		for (int k = low; k < high + 1; k++) {
			minInSubArray = Math.min(minInSubArray, arr[k]);
			maxInSubArray = Math.max(maxInSubArray, arr[k]);
		}

		// extend the subarray
		while (low > 0 && arr[low - 1] > minInSubArray)
			low--;
		// extend the subarray
		while (high < arr.length - 1 && arr[high + 1] < maxInSubArray)
			high++;

		return high - low + 1;
	}

	public static void main(String[] args) {
		System.out.println(MinimumWindowSort.window(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
	}
}
