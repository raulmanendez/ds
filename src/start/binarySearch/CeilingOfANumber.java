package start.binarySearch;

public class CeilingOfANumber {

	static int find(int arr[], int target) {

		int start = 0, end = arr.length - 1;

		if (target > arr[end])
			return -1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}

		return start;
	}

	public static void main(String[] args) {

		System.out.println(find(new int[] { 4, 6, 10 }, 6));
		System.out.println(find(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(find(new int[] { 4, 6, 10 }, 17));
		System.out.println(find(new int[] { 4, 6, 10 }, -1));
	}
}
