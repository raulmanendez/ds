package start.binarySearch;

public class NumberRange {

	static int[] range(int arr[], int target) {
		int result[] = new int[] { -1, -1 };
		result[0] = range(arr, target, false);
		if (result[0] != -1) {
			result[1] = range(arr, target, true);
		}
		return result;
	}

	static int range(int arr[], int key, boolean findMaxIndex) {
		int keyIndex = -1;
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (key < arr[mid]) {
				end = mid - 1;
			} else if (key > arr[mid]) {
				start = mid + 1;
			} else {
				keyIndex = mid;

				if (findMaxIndex)
					start = mid + 1;// search forward
				else
					end = mid - 1;// search backward
			}

		}

		return keyIndex;
	}

	public static void main(String[] args) {

		int result[] = range(new int[] { 4, 6, 6, 6, 9 }, 6);
		System.out.println(result[0] + " " + result[1]);

		result = range(new int[] { 1, 3, 8, 10, 15 }, 10);
		System.out.println(result[0] + " " + result[1]);

		result = range(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println(result[0] + " " + result[1]);
	}
}
