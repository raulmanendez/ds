package start.xor;

import start.Util;

public class FlipAndReverse {

	static void fnr(int input[][]) {
		int L = input[0].length;
		
		for(int arr[]:input) {
			
			for(int i=0;i< (L +1)/2;i++) {
				int temp  = arr[i] ^ 1;
				
				arr[i] = arr[L - 1 - i] ^ 1; 
				arr[L - 1 - i] = temp;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int input[][] = new int[][] {
			{1,0,0,1},
			{1,0,1,0},
			{1,1,0,1}
		};
		
		Util.print(input);
		
		fnr(input);
		
		Util.print(input);
	}
}
