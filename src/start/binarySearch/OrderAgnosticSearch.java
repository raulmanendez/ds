package start.binarySearch;

public class OrderAgnosticSearch {

	static int find(int arr[], int target) {

		int start = 0, end = arr.length - 1;

		boolean ascending = arr[start] < arr[end];
		
		while (start <= end) {

			int mid = start + (end - start) / 2;
			System.out.println(start+" "+" "+end+" "+mid);

			if (arr[mid] == target)
				return mid;

			if (target < arr[mid]) {
				if(ascending)
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if(ascending)
					start = mid + 1;
				else 
					end = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		System.out.println(
		find(new int[] { 2, 3, 4, 6, 8 ,10 }, 10)
				);
		
		System.out.println(
				find(new int[] { 10, 8,5,3,1 }, 3)
						);
	}
}
