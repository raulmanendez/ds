package start.kth;

import java.util.PriorityQueue;

public class TopKNumbers {

	static void topK(int input[], int k) {
		var minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int i = 0; i < k; i++)
			minHeap.offer(input[i]);

		for (int i = k; i < input.length; i++) {

			if (input[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(input[i]);
			}

		}

		System.out.println(minHeap);

	}

	public static void main(String[] args) {
		topK(new int[] { 3, 1, 5, 12, 2, 11 }, 3);// 5, 12, 11
		topK(new int[] { 5, 12, 11, -1, 12 }, 3);// 12, 11, 12

	}
}
