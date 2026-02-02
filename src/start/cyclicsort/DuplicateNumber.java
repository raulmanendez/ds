package start.cyclicsort;

import start.Util;

public class DuplicateNumber {
	static int findDuplicate(int arr[]) {
		Util.print(arr);
		int i = 0;
		while (i < arr.length) {

			if (arr[i] != i + 1) {
				int j = arr[i] - 1;
				if (arr[i] != arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				} else {
					return arr[i];
				}
			} else {
				i++;
			}

		}
		return -1;
	}

	public static void main(String[] args) {

		int x = DuplicateNumber.findDuplicate(new int[] { 2, 1, 3, 3, 5, 4 });

		System.out.println(x);

	}
}
