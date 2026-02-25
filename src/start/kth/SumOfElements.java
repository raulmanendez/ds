package start.kth;

import java.util.PriorityQueue;

public class SumOfElements {

	static int sumOfElements(int arr[], int k1, int k2) {
		var minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int x : arr)
			minHeap.add(x);

		for (int i = 0; i < k1; i++)
			minHeap.poll();

		int sum = 0;
		for (int i = 0; i < k2 - k1 - 1; i++) {
			sum += minHeap.poll();
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sumOfElements(new int[] {1, 3, 12, 5, 15, 11}, 3, 6));//23
		System.out.println(sumOfElements(new int[] {3, 5, 8, 7}, 1, 4));//12
	}
}
