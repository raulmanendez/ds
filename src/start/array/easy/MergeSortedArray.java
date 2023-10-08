package start.array.easy;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int p1=m-1, p2=n-1, p=nums1.length-1;
		
		while(p2>=0) {
			//System.out.println(p1+" "+p2);
			
			if(nums1[p1] >= nums2[p2]) {
				nums1[p]=nums1[p1];
				
				p1--;
				
			} else if(nums1[p1] < nums2[p2]) {
				nums1[p]=nums2[p2];
				
				p2--;
			}
			
			MyArrayUtil.printArray(nums1);
			
			p--;
			
		}
		System.out.println(p1+" "+p2);
		
		for(int i=0;i<=p2;i++)
			nums1[i]=nums2[i];
		
		
	}
	

	public static void main(String[] args) {

		int arr_1[] = new int[] { 0 };
		int arr_2[] = new int[] { 1 };

		merge(arr_1,0, arr_2 , 1);

		for (int x : arr_1)
			System.out.println(x);
		
		System.out.println();
		
		for (int x : arr_2)
			System.out.println(x);
	}
}
