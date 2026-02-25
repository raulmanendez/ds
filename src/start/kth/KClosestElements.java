package start.kth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Entry {
	int key, value;

	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class KClosestElements {

	static List<Integer> closest(int arr[], int k, int x) {
		int closestIndex = binarySearch(arr, x);

		int low = Math.max(closestIndex - k, 0);
		int high = Math.min(closestIndex + k, arr.length - 1);

		var minHeap = new PriorityQueue<Entry>((a, b) -> a.key - b.key);

		for (int i = low; i <= high; i++)
			minHeap.add(new Entry(Math.abs(arr[i] - x), arr[i]));

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++)
			result.add(minHeap.poll().value);
		
		Collections.sort(result);
		return result;
	}

	static int binarySearch(int arr[], int target) {

		int low = 0, high = arr.length - 1;

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		if (low > 0)
			return low - 1;
		return low;
	}

	public static void main(String[] args) {

		System.out.println(closest(new int[] { 5, 6, 7, 8, 9 }, 3, 7));// [6, 7, 8]
		System.out.println(closest(new int[] { 2, 4, 5, 6, 9 }, 3, 6));// [4, 5, 6]
		System.out.println(closest(new int[] { 2, 4, 5, 6, 9 }, 3, 10));// [5, 6, 9]

	}
}
