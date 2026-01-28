package start.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	static List<Interval<Integer>> insert(List<Interval<Integer>> input, Interval<Integer> newInterval) {
		System.out.println("input=> "+input+" | newInterval =>"+newInterval);
		List<Interval<Integer>> result = new ArrayList<>();
		
		int i=0;
		while(i< input.size() && input.get(i).end <= newInterval.start) {
			result.add(input.get(i));
			i++;
		}
		
		while(i< input.size() && input.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(input.get(i).start, newInterval.start);
			newInterval.end = Math.max(input.get(i).end, newInterval.end);
			i++;
		}
		
		result.add(newInterval);
		
		while(i< input.size()) {
			result.add(input.get(i));
			i++;
		}
		
		System.out.println(result);
		return result;
	}
	
	
	public static void main(String[] args) {
		var input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(1, 3));
		input.add(new Interval<Integer>(5, 7));
		input.add(new Interval<Integer>(8, 12));
		insert(input, new Interval<Integer>(4, 6));
	}
}
