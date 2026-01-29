package start.intervals;

import java.util.ArrayList;
import java.util.List;

public class MeetingRooms {

	static boolean clash(List<Interval<Integer>> schedule) {
		if(schedule.size() < 2) return true;
		
		schedule.sort((a,b) -> a.start - b.start);
		for (int i = 1; i < schedule.size(); i++) {

			if (schedule.get(i).start < schedule.get(i - 1).end) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		var input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(6, 7));
		input.add(new Interval<Integer>(2, 4));
		input.add(new Interval<Integer>(8, 12));
		System.out.println(clash(input));
		
		input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(4, 5));
		input.add(new Interval<Integer>(2, 3));
		input.add(new Interval<Integer>(3, 6));
		input.add(new Interval<Integer>(5, 7));
		input.add(new Interval<Integer>(7, 8));
		System.out.println(clash(input));
	}

}
