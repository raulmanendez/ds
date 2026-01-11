package start.twopointers;

import start.Util;

public class RemoveDuplicates {

	static void remove(int arr[]) {

		int end = 1, nonDuplicate = 0;

		while (end < arr.length) {

			if (arr[end] != arr[nonDuplicate]) {
				nonDuplicate++;
				arr[nonDuplicate] = arr[end];
			}
			
			end++;
		}

		Util.print(arr);
	}
	
	static void removeV2(int arr[]) {

		int end = 1, nonDuplicate = 1;

		while (end < arr.length) {

			if (arr[end] != arr[end-1]) {
				arr[nonDuplicate] = arr[end];
				nonDuplicate++;
			}
			
			end++;
		}

		Util.print(arr);
	}

	public static void main(String[] args) {

		RemoveDuplicates.remove(new int[] { 2, 3, 3, 3, 6, 9, 9 });
		RemoveDuplicates.removeV2(new int[] { 2, 3, 3, 3, 6, 9, 9 });
	}

}
