package start.array.easy;

public class MaxProfit {

	public static int maxProfit(int[] prices) {
		int min=prices[0];
		int maxProfit=0;

		for(int i=1;i<prices.length;i++) {
			maxProfit=Math.max(maxProfit,prices[i]-min);
			min=Math.min(prices[i], min);
		}

		return maxProfit;
	}


	public static void main(String[] args) {
		int arr[]=new int[] {7,1,5,3,6,4};

		System.out.println(maxProfit(arr));
	}
}
