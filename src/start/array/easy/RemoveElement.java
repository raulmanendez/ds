package start.array.easy;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		int length = removeElement(arr, 2);

//		int arr[] = new int[] { 3,2,2,3 };
//		int length = removeElement(arr, 3);

		for (int i = 0; i < length; i++) {
			System.out.println(arr[i]);
		}
	}
}
