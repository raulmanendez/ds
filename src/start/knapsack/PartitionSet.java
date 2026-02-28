package start.knapsack;

public class PartitionSet {

	static boolean canPartition(int arr[]) {
		int sum = 0;
		for (int num : arr)
			sum += num;

		if (sum % 2 != 0)
			return false;

		return canPartitionRecurse(arr, sum / 2, 0);
	}

	static boolean canPartitionRecurse(int arr[], int sum, int currentIndex) {
		if (sum == 0)
			return true;

		if (arr.length == 0 || currentIndex >= arr.length)
			return false;

		if (sum >= arr[currentIndex]) {
			if (canPartitionRecurse(arr, sum - arr[currentIndex], currentIndex + 1))
				return true;
		}

		return canPartitionRecurse(arr, sum, currentIndex + 1);
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 2, 3, 4 }));
		System.out.println(canPartition(new int[] { 1, 1, 3, 4, 7 }));
		System.out.println(canPartition(new int[] { 2, 3, 4, 6 }));

	}
}
