package start.ctci.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dikstra {

	static class Point implements Comparable<Point> {
		int vertex;
		int weight;

		public Point(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point arg0) {
			return this.weight - arg0.weight;
		}

		@Override
		public String toString() {
			return vertex + "@" + weight;
		}
	}

	static List<Integer> shortest(int n, List<List<Integer>> points, int start) {
		List<Integer> distances = new ArrayList<>();
		Map<Integer, List<Point>> graph = new HashMap<>();
		PriorityQueue<Point> pq = new PriorityQueue<>();

		// initialize distance array
		for (int i = 0; i < n; i++) {
			distances.add(Integer.MAX_VALUE);
		}
		// start is 0 away from itself
		distances.set(start, 0);

		// create graph
		for (List<Integer> point : points) {
			graph.putIfAbsent(point.get(0), new ArrayList<>());
			graph.putIfAbsent(point.get(1), new ArrayList<>());

			graph.get(point.get(0)).add(new Point(point.get(1), point.get(2)));
			graph.get(point.get(1)).add(new Point(point.get(0), point.get(2)));
		}

		System.out.println(graph);

		pq.add(new Point(start, 0));

		while (!pq.isEmpty()) {
			var current = pq.poll();
			System.out.println("polled => " + current.vertex);

			if (current.weight > distances.get(current.vertex))
				continue;

			for (Point neighbour : graph.get(current.vertex)) {
				System.out.println("neighbour->" + neighbour);

				var neighbourWeight = neighbour.weight + current.weight;

				if (neighbourWeight < distances.get(neighbour.vertex)) {
					distances.set(neighbour.vertex, neighbourWeight);
					pq.add(new Point(neighbour.vertex, neighbourWeight));
				}
			}
			System.out.println("pq=>" + pq);
			System.out.println("distances=>" + distances);
		}

		return distances;
	}

	public static void main(String[] args) {

		List<List<Integer>> points = new ArrayList<>();
		points.add(List.of(0, 1, 5));
		points.add(List.of(0, 2, 3));
		points.add(List.of(1, 2, 1));
		points.add(List.of(1, 3, 4));
		points.add(List.of(2, 3, 4));
		points.add(List.of(2, 4, 5));
				
		System.out.println(shortest(6, points, 0));
	}
}
