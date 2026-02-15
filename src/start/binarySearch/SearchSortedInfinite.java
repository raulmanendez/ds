package start.binarySearch;

public class SearchSortedInfinite {

	static class ArrayReader {
		int arr[];

		public ArrayReader(int arr[]) {
			this.arr = arr;
		}

		public int get(int index) {
			if (index >= arr.length)
				return Integer.MAX_VALUE;

			return arr[index];
		}

	}

	static int search(int arr[], int key) {
		int start = 0, end = 1;
		ArrayReader reader = new ArrayReader(arr);

		while (key > reader.get(end)) {
			int newStart = end + 1;
			end += (end - start + 1) * 2;
			start = newStart;
		}

		return search(reader, start, end, key);
	}

	static int search(ArrayReader reader, int start, int end, int key) {
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (key < reader.get(mid)) {
				end = mid - 1;
			} else if (key > reader.get(mid)) {
				start = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}, 16));	
	}
}
