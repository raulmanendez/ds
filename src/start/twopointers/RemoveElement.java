package start.twopointers;

import start.Util;

public class RemoveElement {

	static void remove(int arr[], int k) {

		int n = arr.length;
		int i=0;
		while (i< n) {
			if (arr[i] == k) {
				arr[i]= arr[n-1];
				n= n-1;
			} else {
				i++;
			}
		}

		System.out.println(n);
		Util.print(arr);
	}

	public static void main(String[] args) {
		int input[] = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
		Util.print(input);
		RemoveElement.remove(input, 3);//4
	}
}
