package start.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntersectionInterval {

	static List<Interval<Integer>> intersection(
			List<Interval<Integer>> first,
			List<Interval<Integer>> second) {

		System.out.println("first -> " + first);
		System.out.println("input -> " + second);


		int i = 0;
		int j = 0;
		List<Interval<Integer>> result = new ArrayList<>();
		while (i < first.size() && j< second.size()) {
			
			int overlapStart = Math.max(first.get(i).start, second.get(j).start);
			int overlapEnd = Math.min(first.get(i).end, second.get(j).end);
			
			if(overlapStart <= overlapEnd) {
				result.add(new Interval<Integer>(overlapStart, overlapEnd));
			}
			
			if(first.get(i).end < second.get(j).end) {
				i++;
			} else {
				j++;
			}
		}
		/*
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {1,3});
		
		list.toArray(new int[list.size()][]);
		*/
		
		System.out.println("result -> " + result);
		return result;
	}

	public static void main(String[] args) {

		var input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(1, 3));
		input.add(new Interval<Integer>(5, 7));
		input.add(new Interval<Integer>(9, 12));
		
		
		var input1 = new ArrayList<Interval<Integer>>();
		input1.add(new Interval<Integer>(5, 10));
		intersection(input, input1);

	}

}
