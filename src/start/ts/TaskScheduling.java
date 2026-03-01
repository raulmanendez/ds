package start.ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaskScheduling {

	static boolean canSchedule(int vertices, int tasks[][]) {
		List<Integer> result = new ArrayList<>();
		if (vertices <= 0)
			return false;

		var inDegree = new HashMap<Integer, Integer>();
		var graph = new HashMap<Integer, List<Integer>>();

		// initialize graph
		for (int i = 0; i < vertices; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}

		// build graph
		for (int i = 0; i < tasks.length; i++) {
			int parent = tasks[i][0], child = tasks[i][1];

			inDegree.put(child, inDegree.get(child) + 1);
			graph.get(parent).add(child);
		}

		// System.out.println(graph + " " + inDegree);

		var sources = new LinkedList<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			if (inDegree.get(entry.getKey()) == 0) {
				sources.add(entry.getKey());
			}
		}

		while (!sources.isEmpty()) {
			var vertex = sources.poll();
			result.add(vertex);

			List<Integer> children = graph.get(vertex);
			for (int childVertex : children) {

				inDegree.put(childVertex, inDegree.get(childVertex) - 1);
				if (inDegree.get(childVertex) == 0) {
					sources.add(childVertex);
				}
			}
		}

		return result.size() == vertices;
	}

	public static void main(String[] args) {

		System.out.println(canSchedule(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }));
		System.out.println(canSchedule(4, new int[][] { { 3, 2 }, { 3, 0 }, { 2, 0 }, { 2, 1 } }));
		System.out.println(canSchedule(5, new int[][] { { 4, 2 }, { 4, 3 }, { 2, 0 }, { 2, 1 }, { 3, 1 } }));
		System.out.println(canSchedule(7,
				new int[][] { { 6, 4 }, { 6, 2 }, { 5, 3 }, { 5, 4 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 4, 1 } }));
	}
}
