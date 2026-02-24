package start.kth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	static List<Integer> topK(int input[], int k) {
		Map<Integer, Integer> fMap = new HashMap<>();
		for(int num : input) 
			fMap.put(num, fMap.getOrDefault(num, 0) + 1);
		
		/*
		 * way 1 using max Heap
		var maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b) -> {
			return b.getValue() - a.getValue();
		});
		
		
		for(Map.Entry<Integer, Integer> entry : fMap.entrySet()) {
			maxHeap.add(entry);
		}
		
		List<Integer> topK = new ArrayList<>();
		while(k!=0) {
			topK.add(maxHeap.poll().getKey());
			k--;
		}
		*/
		
		var minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b) -> {
			return a.getValue() - b.getValue();
		});
		
		for(Map.Entry<Integer, Integer> entry : fMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k) 
				minHeap.poll();
		}
		
		List<Integer> topK = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			topK.add(minHeap.poll().getKey());
		}
		
		return topK;
	}

	public static void main(String[] args) {
		System.out.println(topK(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2));//[12, 11]
		System.out.println(topK(new int[] { 5, 12, 11, 3, 11 }, 2));//[11, 5] or [11, 12] or [11, 3]
	}
}
