package start.array.easy;

public class ThirdLargest {

	public static int thirdMax(int[] nums) {
int t=nums[0],s=nums[0],f=nums[0];

		for(int i=1;i<nums.length;i++) {

			if(nums[i] > t) {
				f=s;
				s=t;
				t=nums[i];
			} else if(nums[i] > s) {
				f=s;
				s=nums[i];
			} else if(nums[i] > f) {
				f=nums[i];
			}
		}

		return t;
	}

	public static void main(String[] args) {

		System.out.println(thirdMax(new int[] {1,2,3,4,5,6}));
	}
}
