package start.kth;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	static String topK(String input) {
		Map<Character, Integer> fMap = new HashMap<>();
		for(char ch : input.toCharArray()) 
			fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);
		
		var maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((a,b) -> {
			return b.getValue() - a.getValue();
		});

		/*
		for(Map.Entry<Character, Integer> entry : fMap.entrySet()) {
			maxHeap.add(entry);
		}
		*/
		
		maxHeap.addAll(fMap.entrySet());
		
		StringBuilder sortedString = new StringBuilder(input.length());
		while(!maxHeap.isEmpty()) {
			var polled = maxHeap.poll();
			
			for(int i=0;i< polled.getValue();i++)
				sortedString.append(polled.getKey());
		}
		
		return sortedString.toString();
	}

	public static void main(String[] args) {
		System.out.println(topK("Programming"));//rrggmmPiano
		System.out.println(topK("abcbab"));//bbbaac
	}
}
