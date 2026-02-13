package start.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	static List<List<Integer>> subsets(int input[]) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		for (int currentNumber : input) {
			int size = result.size();

			for (int j = 0; j < size; j++) {
				List<Integer> list = new ArrayList<>(result.get(j));
				list.add(currentNumber);

				result.add(list);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 5, 3 }));
	}
}
