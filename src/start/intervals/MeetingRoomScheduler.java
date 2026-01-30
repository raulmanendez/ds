package start.intervals;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MeetingRoomScheduler {

	static int roomsNeeded(ArrayList<Interval<Integer>> input) {
		input.sort((a, b) -> a.start - b.start);

		PriorityQueue<Interval<Integer>> minHeap = new PriorityQueue<>(input.size(), (a, b) -> {
			return a.end - b.end;
		});

		int rooms = 0;
		for (Interval<Integer> interval : input) {

			while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
				minHeap.poll();
			}

			minHeap.offer(interval);

			rooms = Math.max(rooms, minHeap.size());
			System.out.println("minHeap -> " + minHeap + " | rooms->" + rooms);

		}

		return rooms;
	}

	public static void main(String[] args) {
		var input = new ArrayList<Interval<Integer>>();
		input.add(new Interval<Integer>(4, 5));
		input.add(new Interval<Integer>(2, 3));
		input.add(new Interval<Integer>(2, 4));
		input.add(new Interval<Integer>(3, 5));
		input.add(new Interval<Integer>(9, 10));
		System.out.println(roomsNeeded(input));
	}
}
