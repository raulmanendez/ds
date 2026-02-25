package start.kth;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {

	static int maximumDistinctElements(int nums[], int k) {
		int distinctElementsCount = 0;
		if (nums.length <= k)
			return distinctElementsCount;

		var fm = new HashMap<Integer, Integer>();

		for (int num : nums)
			fm.put(num, fm.getOrDefault(num, 0) + 1);

		var minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : fm.entrySet()) {
			if (entry.getValue() == 1)
				distinctElementsCount++;
			else
				minHeap.add(entry);
		}

		while (k > 0 && !minHeap.isEmpty()) {
			var entry = minHeap.poll();

			k -= entry.getValue() - 1;

			if (k >= 0)
				distinctElementsCount++;

		}

		if (k >= 0)
			distinctElementsCount -= k;

		return distinctElementsCount;
	}

	public static void main(String[] args) {
		System.out.println(maximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2));// 3
		System.out.println(maximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3));// 2
		System.out.println(maximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2));// 3

	}
}
