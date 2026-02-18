package start.binarySearch;

public class RotationCountOfRotatedArray {

	static int findCount(int arr[]) {

		int start = 0, end = arr.length - 1;

		while (start < end) {

			int mid = start + (end - start) / 2;

			if (mid < end && arr[mid] > arr[mid + 1])
				return mid + 1;
			if (mid > start && arr[mid] < arr[mid - 1])
				return mid;

			if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
				if (arr[start] > arr[start + 1])
					return start + 1;
				start++;

				if (arr[end - 1] > arr[end])
					return end;
				end--;
			} else if (arr[start] < arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findCount(new int[] { 3, 3, 7, 3 }));// 3
	}
}
