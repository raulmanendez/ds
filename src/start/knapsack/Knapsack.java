package start.knapsack;

public class Knapsack {

	static int solveKnapsack(int weights[], int profits[], int capacity) {
		return knapsackRecurse(weights, profits, capacity, 0);
	}

	static int knapsackRecurse(int weights[], int profits[], int capacity, int currentIndex) {

		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		int profit1 = 0;
		if (weights[currentIndex] <= capacity) {
			profit1 = profits[currentIndex]
					+ knapsackRecurse(weights, profits, capacity - weights[currentIndex], currentIndex + 1);
		}
		
		int profit2 = knapsackRecurse(weights, profits, capacity, currentIndex + 1);

		return Math.max(profit1, profit2);
	}

	public static void main(String[] args) {
		int profits[] = {1,6,10,16};
		int weights[] = {1,2,3,5};
		
		int maxProfit = solveKnapsack(weights, profits, 7);
		System.out.println("For Capacity 7=>"+maxProfit);
		
		maxProfit = solveKnapsack(weights, profits, 6);
		System.out.println("For Capacity 6=>"+maxProfit);
		
		
	}
}
