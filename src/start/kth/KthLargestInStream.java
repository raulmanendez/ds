package start.kth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInStream {

	Queue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
	int k;

	public KthLargestInStream(int input[], int k) {
		this.k = k;
		for(int i=0;i<input.length;i++) 
			add(input[i]);
	}
	
	//works 
	private void sortTopK(int input[]) {
		var maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
		
		for(int x :input) {
			maxHeap.add(x);
		}
		
		for(int i=0;i<k;i++) 
			minHeap.add(maxHeap.poll());
		
		System.out.println(minHeap);
	}
	
	public int add(int num) {
		minHeap.add(num);
		if(minHeap.size() > k) {
			minHeap.poll();
		}
		
		return minHeap.peek();
	}

	public int addV1(int num) {
		if(num > minHeap.peek()) {
			minHeap.poll();
			minHeap.add(num);
		}
		
		return minHeap.peek();
	}

	public static void main(String[] args) {
		KthLargestInStream input = new KthLargestInStream(new int[] { 3, 1, 5, 12, 2, 11 }, 4);
		
		System.out.println(input.add(6));//5
		System.out.println(input.add(13));//6
		System.out.println(input.add(4));//6
	}
}
