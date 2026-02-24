package start.kth;

import java.util.PriorityQueue;

public class KthSmallest {

	static int smallest(int input[], int k) {

		var maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

		for (int i = 0; i < k; i++) {
			maxHeap.add(input[i]);
		}

		for (int i = k; i < input.length; i++) {

			if (input[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(input[i]);
			}

		}

		return maxHeap.peek();
	}

	public static void main(String[] args) {
		System.out.println(smallest(new int[] { 3, 1, 5, 12, 2, 11 }, 3));// 3
		System.out.println(smallest(new int[] { 5, 12, 11, -1, 12 }, 3));// 11

	}
}
