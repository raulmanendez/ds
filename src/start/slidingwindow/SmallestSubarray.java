package start.slidingwindow;

public class SmallestSubarray {

	int smallest(int arr[], int targetSum) {

		int left = 0, sum = 0, mink = Integer.MAX_VALUE;
		for (int right = 0; right < arr.length; right++) {

			sum += arr[right];
			while (sum >= targetSum) {
				mink = Math.min(right - left + 1, mink);

				sum -= arr[left];
				left++;
			}

		}

		return mink;
	}

	public static void main(String[] args) {

		System.out.println(new SmallestSubarray().smallest(new int[] { 1, 3, 6, 3, 1, 3, 4, 6, 5 }, 11));
	}
}
