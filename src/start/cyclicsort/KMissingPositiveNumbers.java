package start.cyclicsort;


import java.util.ArrayList;
import java.util.List;

import start.Util;

public class KMissingPositiveNumbers {
	
	static void findMissing(int arr[], int k) {
		Util.print(arr);
		int i = 0;
		
		while(i< arr.length) {
			var j = arr[i] - 1;
			if(arr[i] <= arr.length && arr[i] > 0 && arr[i]!=arr[j]) {
				int temp =  arr[i];
				arr[i] = arr[j];
				arr[j] = temp;	
			} else {
				i++;
			}
		}
		
		Util.print(arr);
		
		List<Integer> missingNumbers = new ArrayList<>();
		List<Integer> extraNumbers = new ArrayList<>();
		for(int l=0;l<arr.length && missingNumbers.size() < k;l++) {
			if(arr[l]!= l+1) {
				missingNumbers.add(l+1);
				extraNumbers.add(arr[l]);
			}
		}
		
		for(int l=1; missingNumbers.size() < k;l++) {
			int candidateNumber = l + arr.length;
			
			if(!extraNumbers.contains(candidateNumber)) {
				missingNumbers.add(candidateNumber);
			}
		}

		System.out.println("result => "+missingNumbers);
	}

	public static void main(String[] args) {
		KMissingPositiveNumbers.findMissing(new int[] { 3, -1, 4, 5, 5 }, 3);
		KMissingPositiveNumbers.findMissing(new int[] { 2, 3, 4 }, 3);
		KMissingPositiveNumbers.findMissing(new int[] { -2, -3, 4 }, 2);
	}
}
