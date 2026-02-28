package start.knapsack;

public class PartitionSetWithMemoization {

	static boolean canPartition(int arr[]) {
		int sum = 0;
		for (int num : arr)
			sum += num;

		if (sum % 2 != 0)
			return false;

		Boolean dp[][] = new Boolean[arr.length][sum / 2 + 1];
		return canPartitionRecurse(dp, arr, sum / 2, 0);
	}

	static boolean canPartitionRecurse(Boolean dp[][], int arr[], int sum, int currentIndex) {
		if (sum == 0)
			return true;

		if (arr.length == 0 || currentIndex >= arr.length)
			return false;

		if (dp[currentIndex][sum] == null) {
			if (sum >= arr[currentIndex]) {
				if (canPartitionRecurse(dp, arr, sum - arr[currentIndex], currentIndex + 1)) {
					dp[currentIndex][sum] = true;
					return true;
				}
			}

			dp[currentIndex][sum] = canPartitionRecurse(dp, arr, sum, currentIndex + 1);
		}

		return dp[currentIndex][sum];
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 2, 3, 4 }));
		System.out.println(canPartition(new int[] { 1, 1, 3, 4, 7 }));
		System.out.println(canPartition(new int[] { 2, 3, 4, 6 }));

	}
}
