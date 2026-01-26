package start.intervals;

import java.util.ArrayList;
import java.util.List;

public class IsIntervalOverlap {

	static boolean overlap(List<Interval<Integer>> input) {
		System.out.println(input);
		input.sort((a, b) -> a.start - b.start);

		for (int i = 1; i < input.size(); i++) {
			var previous = input.get(i - 1);
			var current = input.get(i);

			if (current.start <= previous.end)
				return true;

		}

		return false;
	}

	public static void main(String[] args) {

		var input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(1, 4));
		input.add(new Interval<Integer>(2, 5));
		input.add(new Interval<Integer>(7, 9));
		System.out.println(overlap(input));
	}
}
