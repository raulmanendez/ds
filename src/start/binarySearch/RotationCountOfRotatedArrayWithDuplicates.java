package start.binarySearch;

public class RotationCountOfRotatedArrayWithDuplicates {


	//actually the index of smallest element in array
	static int findCount(int arr[]) {
		
		int start =0, end = arr.length - 1;
		
		while(start < end) {
			
			int mid = start + (end - start)/2;
			
			if(mid < end && arr[mid] > arr[mid+1]) return mid + 1;
			if(mid > start && arr[mid] < arr[mid - 1]) return mid;
			
			if(arr[start] < arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findCount(new int[] {10, 15, 1, 3, 8}));//2
		System.out.println(findCount(new int[] {4, 5, 7, 9, 10, -1, 2}));//5
		System.out.println(findCount(new int[] {1, 3, 8, 10}));//0
	}
}
