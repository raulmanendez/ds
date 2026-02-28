package start.knapsack;

public class KnapsackBottomUp {

	static int solve(int weights[], int profits[], int capacity) {

		if (capacity <= 0 || profits.length == 0 || profits.length != weights.length)
			return 0;

		int n = profits.length;
		int dp[][] = new int[n][capacity + 1];

		for (int i = 0; i < n; i++)
			dp[i][0] = 0;

		for (int c = 0; c <= capacity; c++) {
			if (weights[0] <= c)
				dp[0][c] = profits[0];
		}

		for (int i = 1; i < n; i++) {
			for (int c = 1; c <= capacity; c++) {

				int profit1 = 0;

				if (weights[i] <= c) {
					profit1 = profits[i] + dp[i - 1][c - weights[i]];
				}

				int profit2 = dp[i - 1][c];

				dp[i][c] = Math.max(profit1, profit2);
			}
		}

		return dp[n - 1][capacity];
	}

	public static void main(String[] args) {
		int profits[] = { 1, 6, 10, 16 };
		int weights[] = { 1, 2, 3, 5 };

		int maxProfit = solve(weights, profits, 7);
		System.out.println("For Capacity 7=>" + maxProfit);

		maxProfit = solve(weights, profits, 6);
		System.out.println("For Capacity 6=>" + maxProfit);

	}
}
