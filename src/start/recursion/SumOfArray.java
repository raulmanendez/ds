package start.recursion;

public class SumOfArray {

	public static int sum(int arr[],int start) {
		if(start==arr.length)
			return 0;
		else
			return arr[start] + sum(arr, start+1);
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};//15
		System.out.println("Sum of array elements::"+sum(arr,0));
	}
}
