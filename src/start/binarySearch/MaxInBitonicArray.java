package start.binarySearch;

public class MaxInBitonicArray {

	static int findMax(int arr[]) {
		int start = 0, end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > arr[mid + 1])
				end = mid;
			else
				start = mid + 1;

		}

		return arr[start];
	}

	public static void main(String[] args) {
		System.out.println(findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
	}
}
