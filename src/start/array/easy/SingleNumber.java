package start.array.easy;

public class SingleNumber {

	public static int singleNumber(int[] nums) {

		int result=0;
		
		for(int x:nums)
			result ^= x;
		
		return result;
	}

	public static void main(String[] args) {
		int arr[]=new int[] {4,1,2,1,2};

		System.out.println(singleNumber(arr));
	}
}
