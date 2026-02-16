package start.binarySearch;

public class MinimumDifference {

	static int searchMinDifference(int arr[], int key) {
		int start=0; int end = arr.length-1;
		if(key < arr[0]) return arr[0];
		if(key > arr[end]) return arr[end];
		
		while(start <= end) {
			
			int mid = start + (end- start)/2;
			if(key > arr[mid]) {
				start = mid +1;
			}else if(key < arr[mid]) {
				end = mid- 1;
			} else {
				return arr[mid];
			}
			
			System.out.println(start +" "+ end);
		}
		
		if(arr[start] - key < key - arr[end])
			return arr[start];
		
		return arr[end];
	}

	public static void main(String[] args) {
		System.out.println(searchMinDifference(new int[] {1, 3, 8, 10, 15}, 12));
	}
}
