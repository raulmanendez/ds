package start.cyclicsort;


import start.Util;

public class SmallestMissingPositive {
	static void findMissing(int arr[]) {
		Util.print(arr);
		int i = 0;

		int result = -1;
		
		while(i< arr.length) {
			var j = arr[i] - 1;
			//System.out.println("i -> "+i+" | j->"+j);
			
			if(arr[i] <= arr.length && arr[i] > 0 && arr[i]!=arr[j]) {
				int temp =  arr[i];
				arr[i] = arr[j];
				arr[j] = temp;	
			} else {
				i++;
			}
		}
		
		Util.print(arr);
		
		for(int k=0;k<arr.length;k++) {
			if(arr[k]!= k+1) {
				result=k+1;
				break;
			}
		}

		System.out.println("result => "+result);
	}

	public static void main(String[] args) {
		SmallestMissingPositive.findMissing(new int[] { -3, 1, 5, 4, 2 });
		SmallestMissingPositive.findMissing(new int[] { 3, -2, 0, 1, 2 });
		SmallestMissingPositive.findMissing(new int[] { 3, 2, 5, 1 });
	}
}
