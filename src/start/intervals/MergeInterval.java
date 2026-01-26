package start.intervals;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {

	static List<Interval<Integer>> mergeInterval(List<Interval<Integer>> input) {

		System.out.println("input -> " + input);

		if (input.size() < 2)
			return input;

		input.sort((a, b) -> a.start - b.start);

		int start = input.get(0).start;
		int end = input.get(0).end;
		List<Interval<Integer>> result = new ArrayList<>();
		for (int i = 1; i < input.size(); i++) {
			var interval = input.get(i);
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				result.add(new Interval<Integer>(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		//last interval
		result.add(new Interval<Integer>(start, end));
		

		System.out.println("result -> " + result);
		return result;
	}

	public static void main(String[] args) {

		var input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(1, 4));
		input.add(new Interval<Integer>(2, 5));
		input.add(new Interval<Integer>(7, 9));
		mergeInterval(input);
		
		var input1 = new ArrayList<Interval<Integer>>();
		input1.add(new Interval<Integer>(6, 7));
		input1.add(new Interval<Integer>(2, 4));
		input1.add(new Interval<Integer>(5, 9));
		mergeInterval(input1);
		
		var input2 = new ArrayList<Interval<Integer>>();
		input2.add(new Interval<Integer>(1, 4));
		input2.add(new Interval<Integer>(2, 6));
		input2.add(new Interval<Integer>(3, 5));
		mergeInterval(input2);

	}

}
