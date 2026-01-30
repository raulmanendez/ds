package start.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCPULoad {

	static class Job {
		int start;
		int end;
		int load;
		
		public Job(int start, int end, int load) {
			super();
			this.start = start;
			this.end = end;
			this.load = load;
		}
		
		@Override
		public String toString() {
			return "["+start+","+end+","+load+"]";
		}
	}
	
	static int maxLoad(ArrayList<Job> jobs) {
		jobs.sort((a, b) -> a.start - b.start);

		PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> {
			return a.end - b.end;
		});

		int currentLoad = 0;
		int maxLoad = 0;
		for (Job job : jobs) {

			while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
				currentLoad -= minHeap.poll().load;
			}

			minHeap.offer(job);
			currentLoad+=job.load;
			maxLoad = Math.max(maxLoad, currentLoad);
			
			System.out.println("minHeap -> " + minHeap + " | maxLoad->" + maxLoad);
		}

		return maxLoad;
	}

	public static void main(String[] args) {
		var input = new ArrayList<Job>();
		input.add(new Job(7, 9, 6));
		input.add(new Job(2, 5, 4));
		input.add(new Job(1, 4, 3));
		
		System.out.println(maxLoad(input));
	}
}
