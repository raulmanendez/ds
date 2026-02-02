package start.cyclicsort;

import start.Util;

public class SortNNumbers {

	static void sort(int arr[]) {
		Util.print(arr);
		for (int i = 0; i < arr.length; i++) {

			int j = arr[i] - 1;
			if (arr[i] != arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			} else {
				i++;
			}
		}

		Util.print(arr);
	}

	public static void main(String[] args) {
		SortNNumbers.sort(new int[] { 2, 6, 4, 3, 1, 5 });

	}
}
