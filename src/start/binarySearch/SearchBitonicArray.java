package start.binarySearch;

public class SearchBitonicArray {


	static int search(int arr[], int key) {
		int maxIndex = findMax(arr);
		System.out.println("maxIndex=>" + maxIndex);

		int result = binarySearchAgnostic(arr, 0, maxIndex, key);
		if (result == -1)
			result = binarySearchAgnostic(arr, maxIndex, arr.length - 1, key);

		return result;
	}

	static int findMax(int arr[]) {

		int start = 0, end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1]) {// descending order
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	static int binarySearchAgnostic(int arr[], int start, int end, int key) {

		boolean ascending = arr[start] < arr[end];
		while (start <= end) {
			int mid = start + (end - start) / 2;
			System.out.println(start + " " + end + " " + mid);

			if (key > arr[mid]) {
				if (ascending) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (key < arr[mid]) {
				if (ascending) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));
		System.out.println(search(new int[] {3,8,3,1}, 8));
		System.out.println(search(new int[] {1,3,8,12}, 12));
		System.out.println(search(new int[] {10,9,8}, 10));
	}
}
