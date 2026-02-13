package start.twoheap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Median {

	Queue<Integer> minHeap;
	Queue<Integer> maxHeap;
	
	
	public Median() {
		 maxHeap = new PriorityQueue<>((a,b) -> b-a);
		 minHeap = new PriorityQueue<>((a,b) -> a-b);
	}
	
	void insertNum(int num) {
		if(maxHeap.isEmpty() || maxHeap.peek() >= num)
			maxHeap.offer(num);
		else
			minHeap.offer(num);
		
		if(maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if(minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
	
	double findMedian() {
		System.out.println("maxHeap => "+maxHeap);
		System.out.println("minHeap => "+minHeap);
		
		if(minHeap.size()!=maxHeap.size())
			return maxHeap.peek();
		
		return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
	
	public static void main(String[] args) {
		var median = new Median();
		median.insertNum(5);
		System.out.println(median.findMedian());
		
		median.insertNum(3);
		System.out.println(median.findMedian());
		
		median.insertNum(7);
		System.out.println(median.findMedian());
		
		median.insertNum(9);
		System.out.println(median.findMedian());
		
		median.insertNum(4);
		System.out.println(median.findMedian());
		
		median.insertNum(1);
		System.out.println(median.findMedian());
		
		median.insertNum(6);
		System.out.println(median.findMedian());
		
		median.insertNum(2);
		System.out.println(median.findMedian());
	}
	
}
