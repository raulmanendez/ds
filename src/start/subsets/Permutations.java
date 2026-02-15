package start.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

	static List<List<Integer>> permutations(int input[]) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
		permutations.add(new ArrayList<>());

		for (int num : input) {
			int n = permutations.size();

			for (int i = 0; i < n; i++) {
				List<Integer> oldPermutations = permutations.poll();

				for (int j = 0; j <= oldPermutations.size(); j++) {
					List<Integer> newPermutations = new ArrayList<>(oldPermutations);
					newPermutations.add(j, num);

					if (newPermutations.size() == input.length)
						result.add(newPermutations);
					else
						permutations.add(newPermutations);
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(permutations(new int[] { 1, 2, 3 }));
	}
}
