package start.kth;

import java.util.PriorityQueue;

public class ConnectRopes {

	static int connectRopes(int input[]) {
		var minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int num : input) {
			minHeap.add(num);
		}

		int cost = 0;
		while (minHeap.size() > 1) {
			int currentCost = minHeap.poll() + minHeap.poll();
			minHeap.add(currentCost);

			cost += currentCost;
		}

		return cost;
	}

	public static void main(String[] args) {
		System.out.println(connectRopes(new int[] { 1, 3, 11, 5, 2 }));// 42
		System.out.println(connectRopes(new int[] { 3, 4, 5, 6 }));// 36
	}
}
