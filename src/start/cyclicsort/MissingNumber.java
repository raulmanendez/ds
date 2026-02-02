package start.cyclicsort;

import start.Util;

public class MissingNumber {
	static int findMissing(int arr[]) {
		Util.print(arr);
		int i = 0;

		while (i < arr.length) {
			int j = arr[i];
			if (j < arr.length && arr[i] != arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			} else {
				i++;
			}

			Util.print(arr);
		}

		for (int j = 0; j < arr.length; j++) {
			if (j != arr[j])
				return j;
		}

		return -1;
	}

	public static void main(String[] args) {

		int x = MissingNumber.findMissing(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 });

		System.out.println(x);

	}
}
