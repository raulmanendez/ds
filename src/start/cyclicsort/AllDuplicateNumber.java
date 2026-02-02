package start.cyclicsort;

import java.util.ArrayList;
import java.util.List;

import start.Util;

public class AllDuplicateNumber {
	static void findDuplicate(int arr[]) {
		Util.print(arr);
		int i = 0;

		while (i < arr.length) {
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

		List<Integer> result = new ArrayList<>();
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != j + 1) {
				result.add(arr[j]);
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		AllDuplicateNumber.findDuplicate(new int[] { 5, 4, 7, 2, 3, 5, 3 });
	}
}
