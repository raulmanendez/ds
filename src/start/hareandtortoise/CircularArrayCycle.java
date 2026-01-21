package start.hareandtortoise;

import start.Util;

public class CircularArrayCycle {

	static boolean hasCycle(int arr[]) {
		Util.print(arr);
		int length = arr.length;

		for (int i = 0; i < length - 1; i++) {
			boolean isForward = arr[i] > 0;
			int slow = i;
			int fast = i;

			while (true) {
				slow = nextIndex(arr, slow, isForward);
				fast = nextIndex(arr, fast, isForward);

				if (fast != -1) {
					fast = nextIndex(arr, fast, isForward);
				}

				if (slow == -1 || fast == -1 || slow == fast)
					break;
			}

			if (slow != -1 && slow == fast)
				return true;

		}

		return false;
	}

	static int nextIndex(int arr[], int currentIndex, boolean isForward) {

		if (arr[currentIndex] >= 0 != isForward) {
			return -1;
		}

		int next = (currentIndex + arr[currentIndex]) % arr.length;
		if (next < 0)
			next += arr.length;

		if (next == currentIndex)
			return -1;

		return next;
	}

	public static void main(String[] args) {
		System.out.println(CircularArrayCycle.hasCycle(new int[] { 1, 2, -1, 2, 2 }));
		System.out.println(CircularArrayCycle.hasCycle(new int[] { 2, 2, -1, 2 }));
		System.out.println(CircularArrayCycle.hasCycle(new int[] { 2, 1, -1, -2 }));

	}
}
