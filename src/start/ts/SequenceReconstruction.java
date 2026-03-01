package start.ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SequenceReconstruction {

	static boolean canReconstruct(int originalSeq[], int sequences[][]) {
		List<Integer> result = new ArrayList<>();
		if (originalSeq.length <= 0)
			return false;

		var inDegree = new HashMap<Integer, Integer>();
		var graph = new HashMap<Integer, List<Integer>>();

		// initialize graph
		for (int sequence[] : sequences)
			for (int i = 0; i < sequence.length; i++) {
				inDegree.putIfAbsent(sequence[i], 0);
				graph.putIfAbsent(sequence[i], new ArrayList<>());
			}

		// build graph
		for (int sequence[] : sequences)
			for (int i = 1; i < sequence.length; i++) {
				int parent = sequence[i - 1], child = sequence[i];

				inDegree.put(child, inDegree.get(child) + 1);
				graph.get(parent).add(child);
			}

		// if ordering is not there for all the numbers then no sequence possible
		if (inDegree.size() != originalSeq.length)
			return false;

		var sources = new LinkedList<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			if (inDegree.get(entry.getKey()) == 0) {
				sources.add(entry.getKey());
			}
		}

		while (!sources.isEmpty()) {
			// more than 1 way is possible
			if (sources.size() > 1)
				return false;

			// next number is different than original sequence
			if (originalSeq[result.size()] != sources.peek())
				return false;

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

		return result.size() == originalSeq.length;
	}

	public static void main(String[] args) {

		System.out.println(canReconstruct(new int[] { 1, 2, 3, 4 }, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));
		System.out.println(canReconstruct(new int[] { 1, 2, 3, 4 }, new int[][] { { 1, 2 }, { 2, 3 }, { 2, 4 } }));
		System.out.println(canReconstruct(new int[] { 3, 1, 4, 2, 5 }, new int[][] { { 3, 1, 5 }, { 1, 4, 2, 5 } }));

	}
}
