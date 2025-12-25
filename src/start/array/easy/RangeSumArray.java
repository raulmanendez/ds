package start.array.easy;

public class RangeSumArray {

	 int nums[]=null;
	    public void NumArray(int[] nums) {
	        this.nums=new int[nums.length];
	        int sum=0;
	        for(int i=0;i<nums.length;i++) {
	            sum+=nums[i];
	            this.nums[i]=sum;
	        }



	    }

	    public int sumRange(int left, int right) {
	    	MyArrayUtil.printArray(nums);

	       return nums[right] - nums[left>0 ? left-1 : 0];
	    }

	public static void main(String[] args) {
		int arr[] = new int[] { -2,0,3,-5,2,-1 };

		RangeSumArray ob=new RangeSumArray();

		ob.NumArray(arr);

		MyArrayUtil.printArray(arr);

		System.out.println( ob.sumRange(0, 2));
		System.out.println( ob.sumRange(2, 5));
		System.out.println( ob.sumRange(0, 5));

	}
}
