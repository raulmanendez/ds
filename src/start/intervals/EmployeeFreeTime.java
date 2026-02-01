package start.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

	static class EmployeeInterval {
		Interval<Integer> interval;
		int employeeIndex;
		int intervalIndex;

		public EmployeeInterval(Interval<Integer> interval, int employeeIndex, int intervalIndex) {
			super();
			this.interval = interval;
			this.employeeIndex = employeeIndex;
			this.intervalIndex = intervalIndex;
		}
	}

	static List<Interval<Integer>> findCommon(List<List<Interval<Integer>>> employeeIntervals) {
		List<Interval<Integer>> result = new ArrayList<Interval<Integer>>();
		
		PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);
		for (int i = 0; i < employeeIntervals.size(); i++) {
			minHeap.offer(new EmployeeInterval(employeeIntervals.get(i).get(0), i, 0));

			Interval<Integer> prev = minHeap.peek().interval;

			while (!minHeap.isEmpty()) {
				var top = minHeap.poll();

				if (prev.end < top.interval.start) {
					result.add(new Interval<Integer>(prev.end, top.interval.start));
					prev = top.interval;
				} else {
					if (prev.end < top.interval.end) {
						prev = top.interval;
					}
				}

				List<Interval<Integer>> moreIntervals = employeeIntervals.get(top.employeeIndex);
				if (moreIntervals.size() > top.intervalIndex + 1) {

					minHeap.offer(new EmployeeInterval(moreIntervals.get(top.intervalIndex + 1), top.employeeIndex,
							top.intervalIndex + 1));
				}
			}

		}

		return result;
	}
	
	static List<Interval<Integer>> findCommonV2(List<List<Interval<Integer>>> schedule) {
		List<Interval<Integer>> intervals = new ArrayList<Interval<Integer>>();
		for (List<Interval<Integer>> e : schedule) {
			intervals.addAll(e);
		}

		intervals.sort((a, b) -> a.start - b.start);

		List<Interval<Integer>> merged = new ArrayList<Interval<Integer>>();
		merged.add(intervals.get(0));

		for (int i = 1; i < intervals.size(); ++i) {

			Interval<Integer> last = merged.get(merged.size() -1);
			Interval<Integer> curr = merged.get(i);

			if (last.end < curr.start) {
				merged.add(curr);
			} else {
				last.end = Math.max(last.end, curr.end);

			}
		}

		List<Interval<Integer>> result = new ArrayList<>();
		for (int i = 1; i < merged.size(); ++i) {

			result.add(
					new Interval<Integer>(
					merged.get(i - 1).end, merged.get(i).start));
		}

		return result;
	}

	//wrong 
	public static void main(String[] args) {
		List<List<Interval<Integer>>> input = new ArrayList<>();

		input.add(Arrays.asList(new Interval<Integer>(1, 3), new Interval<Integer>(5, 6)));// employee 1
		input.add(Arrays.asList(new Interval<Integer>(2, 3), new Interval<Integer>(6, 8)));// employee 2
		System.out.println(findCommon(input));
		
		
		input.clear();
		input.add(Arrays.asList(new Interval<Integer>(1, 3), new Interval<Integer>(9, 12)));// employee 1
		input.add(Arrays.asList(new Interval<Integer>(2, 4)));// employee 2
		input.add(Arrays.asList(new Interval<Integer>(6, 8)));// employee 3
		System.out.println(findCommon(input));
	}
}
