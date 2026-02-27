package start.kwaymerge;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

	private static class Entry {
		int row, col;

		Entry(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int get(int input[][], int k) {
		var mh = new PriorityQueue<Entry>((a,b) -> {
			return input[a.row][a.col] - input[b.row][b.col];
		});
		
		
		for(int i=0;i<input.length && i< k;i++) {
			mh.add(new Entry(i, 0));
		}
		
		int result = 0 , numCount = 0;
		while(!mh.isEmpty()) {
			var polled=mh.poll();
			
			result = input[polled.row][polled.col];
			
			if(++numCount == k) {
				break;
			}
			
			polled.col++;
			
			if(polled.col < input[0].length)
				mh.add(polled);
		}

		return result;
	}

	public static void main(String[] args) {

		int input[][] = new int[][] { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };

		System.out.println(get(input, 5));// 7
		System.out.println(get(input, 8));// 10
	}
}
