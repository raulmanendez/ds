package start.array.easy;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		
		int j=1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[i-1]) {
				nums[j]=nums[i];
				j++;
			}
		}
		
		return j;
	}

	public static void main(String[] args) {
		int arr[]=new int[] {1,1,1,2,2,3,4};
		
		int length=removeDuplicates(arr);
		
		for(int i=0;i<length;i++) {
			System.out.println(arr[i]);
		}
	}
}
