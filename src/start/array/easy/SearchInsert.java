package start.array.easy;

public class SearchInsert {

	public static int searchInsert(int[] nums, int target) {
		int left=0,right=nums.length-1;
		
		while(left <= right) {
			int mid=(left+right)/2;
			
			if(nums[mid]<target) {
				left=mid+1;
			} else if(nums[mid]>target) {
				right=mid-1;
			} else {
				return mid;
			}
			
			System.out.println(left+"  "+right);
		}
		
		return left;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 3,  5, 6 };
		int result = searchInsert(arr, 2);

		System.out.println("Result ::"+result);
	}
}
