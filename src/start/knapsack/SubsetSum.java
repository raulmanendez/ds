package start.knapsack;

public class SubsetSum {

	static boolean canPartition(int arr[], int sum) {
		int n = arr.length;
		boolean dp[][] = new boolean[n][sum + 1];

		for (int i = 0; i < n; i++)
			dp[i][0] = true;

		for (int s = 1; s <= sum; s++) {
			dp[0][s] = (arr[0] == s ? true : false);
		}

		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= sum; s++) {

				if (dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if (s >= arr[i]) {
					dp[i][s] = dp[i - 1][s - arr[i]];
				}

			}
		}

		return dp[n - 1][sum];
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 2, 3, 7 }, 6));
		System.out.println(canPartition(new int[] { 1, 2, 7, 1, 5 }, 10));
		System.out.println(canPartition(new int[] { 1, 3, 4, 8 }, 6));

	}
}
