package start.cyclicsort;

import java.util.ArrayList;
import java.util.List;

import start.Util;

public class CorruptPair {
	static void findCorruptPair(int arr[]) {
		Util.print(arr);
		int i = 0;

		List<Integer> result = new ArrayList<>(2);
		
		
		while(i< arr.length) {
			var j = arr[i] - 1;
			
			if(arr[i]!=arr[j]) {
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
				result.add(arr[k]);
				result.add(k+1);
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		CorruptPair.findCorruptPair(new int[] { 3, 1, 2, 3, 6, 4 });
	}
}
