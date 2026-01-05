package start.slidingwindow;


public class MaximumSum {

	int maxSum(int arr[], int k) {
		int left = 0, sum = 0, max = 0;

		for (int right = 0; right < arr.length; right++) {
			sum += arr[right];
			if (right >= k - 1) {
				max = Math.max(max, sum);

				sum-=arr[left];
				left++;
			}
		}

		return max;
	}

	public static void main(String[] args) {

		System.out.println(
		new MaximumSum().maxSum(new int[] { 1, 2, 3, 2, 3, 1, 7, 1 }, 3)
				);
	}
}
