package start.twopointers;

import start.Util;

public class Squares {

	static int square(int n) {
		return n * n;
	}
	
	static int[] square(int arr[]) {
		int start=0, end=arr.length-1;
		int squares[] = new int[arr.length];
		int pointer = end;
		
		while(start < end) {
			
			int startSquare=square(arr[start]);
			int endSquare=square(arr[end]);
			
			if(startSquare > endSquare) {
				squares[pointer] = startSquare;
				start++;
			} else {
				squares[pointer] = endSquare;
				end--;
			}
			pointer--;
		}
		
		return squares;
	}
	
	
	public static void main(String[] args) {
		Util.print(
				Squares.square(new int[] {-3, -2, 0, 1, 4})
		);
	}
}
