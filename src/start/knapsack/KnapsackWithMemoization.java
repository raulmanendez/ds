package start.knapsack;

public class KnapsackWithMemoization {

	static int solveKnapsack(int weights[], int profits[], int capacity) {
		Integer dp[][] = new Integer[profits.length][capacity + 1];
		return knapsackRecurse(dp, weights, profits, capacity, 0);
	}

	static int knapsackRecurse(Integer dp[][], int weights[], int profits[], int capacity, int currentIndex) {

		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;
		
		if(dp[currentIndex][capacity]!=null) {
			return dp[currentIndex][capacity];
		}

		int profit1 = 0;
		if (weights[currentIndex] <= capacity) {
			profit1 = profits[currentIndex]
					+ knapsackRecurse(dp, weights, profits, capacity - weights[currentIndex], currentIndex + 1);
		}

		int profit2 = knapsackRecurse(dp, weights, profits, capacity, currentIndex + 1);

		dp[currentIndex][capacity] = Math.max(profit1, profit2);
		
		return dp[currentIndex][capacity];
	}

	public static void main(String[] args) {
		int profits[] = { 1, 6, 10, 16 };
		int weights[] = { 1, 2, 3, 5 };

		int maxProfit = solveKnapsack(weights, profits, 7);
		System.out.println("For Capacity 7=>" + maxProfit);

		maxProfit = solveKnapsack(weights, profits, 6);
		System.out.println("For Capacity 6=>" + maxProfit);

	}
}
