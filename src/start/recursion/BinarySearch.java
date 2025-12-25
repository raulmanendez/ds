package start.recursion;

public class BinarySearch {

	private static int binarySearch(int arr[],int low,int high,int search) {
		if(low > high)
			return -1;
		else {
			int mid=(low+high)/2;
			if(arr[mid] > search) {
				return binarySearch(arr, low, mid-1, search);
			} else if(arr[mid] < search) {
				return binarySearch(arr, mid+1, high, search);
			} else {
				return arr[mid];
			}
		}
	}

	public static int binarySearch(int arr[],int search) {


		return binarySearch(arr, 0, arr.length-1,search);
	}


	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9};
		System.out.println("Checking if 2 exists in the array::"+binarySearch(arr,2));
		System.out.println("Checking if 8 exists in the array::"+binarySearch(arr,8));

		System.out.println("Checking if 21 exists in the array::"+binarySearch(arr,21));
	}
}
