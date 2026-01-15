package start.twopointers;

import start.Util;

public class DutchFlag {

	static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	static void sort(int arr[]) {

		int i = 0, low = 0, high = arr.length - 1;

		while (i <= high) {

			if (arr[i] == 0) {
				swap(arr, i, low);
				i++;
				low++;
			} else if (arr[i] == 1) {
				i++;
			} else { // 2
				swap(arr, i, high);
				high--;
			}

		}

		Util.print(arr);
	}

	public static void main(String[] args) {
		DutchFlag.sort(new int[] { 0, 1, 2, 1, 2, 2, 1, 1, 0, 0, 0, 1, 0, 2 });
	}
}
