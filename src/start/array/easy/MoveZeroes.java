package start.array.easy;

public class MoveZeroes {

	public static void moveZeroes(int[] nums) {

		int i = 0;

		for (int num : nums) {
			if (num != 0) {
				nums[i] = num;
				i++;
			}
		}

		for (; i < nums.length; i++) {
			nums[i] = 0;
		}

		MyArrayUtil.printArray(nums);
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 3, 12, 0, 14 };

		moveZeroes(arr);

		MyArrayUtil.printArray(arr);

	}
}
