package start.binarySearch;

public class SearchRoatedArrayWithDuplicate {

	static int search(int arr[], int key) {

		int start =0; int end = arr.length-1;
		
		while(start <= end) {
			int mid =  start + (end - start)/2;
			
			if(arr[mid]==key) return mid;
			
			if(arr[start]== arr[mid] && arr[mid]==arr[end]) {
				start++;
				end--;
			} else if(arr[start] <= arr[mid]) {//first half is sorted 
				if(key >= arr[start] && key < arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}				
				
			}  else {//second half is sorted
				if(key > arr[mid] && key <= arr[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] {3, 7, 3, 3, 3}, 7)); //1
	}

}
