package start.array.recurse;

public class MagicIndex {

	public static int magicIndexDistinct(int arr[]) {
		return magicIndexDistinct(arr, 0, arr.length-1);
	}

	public static int magicIndexDistinct(int arr[],int low,int high) {
		if(low > high) return -1;

		int mid=(low+high)/2;

		if(mid==arr[mid]) {
			return mid;
		} else if(mid < arr[mid]){
			return magicIndexDistinct(arr, low, mid -1);
		} else {
			return magicIndexDistinct(arr, mid+1, high);
		}
	}

	public static int magicIndexNonDistinct(int arr[]) {
		return magicIndexNonDistinct(arr, 0, arr.length-1);
	}

	public static int magicIndexNonDistinct(int arr[],int low,int high) {
		if(high < low) return -1;

		int mid=(low+high)/2;

		if(arr[mid]==mid) {
			return mid;
		}

		int leftIndex=Math.min(mid-1, arr[mid]);
		int leftValue=magicIndexNonDistinct(arr, low, leftIndex);
		if(leftValue > -1) return leftValue;

		int rightIndex=Math.max(arr[mid+1], mid+1);
		int rightValue=magicIndexNonDistinct(arr, rightIndex, high);

		return rightValue;
	}

	public static void main(String[] args) {
		System.out.println("Magic Index in Distinct:"+magicIndexDistinct(new int[] {-10,-9,-8,-7,-6,-5,-4,7}));

		System.out.println("Magic Index in Non-Distinct:"+magicIndexNonDistinct(new int[] {-10,-9,1,2,2,2,6,8}));
	}
}
