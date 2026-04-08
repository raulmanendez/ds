package start.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyPadCombinations {

	static void phoneKeypadCombinations(String target) {
		List<String> result = new ArrayList<>();

		var map = Map.of("2", "abc", "3", "def", "4", "ghi", "5", "jkl", "6", "mno", "7", "pqrs", "8", "tuv", "9",
				"wxyz");
		backtrack(0, new ArrayList<>(), target, map, result);
		System.out.println(result);
	}

	static void backtrack(int startIndex, List<String> combination, String target, Map<String, String> map,
			List<String> result) {

		System.out.println("combination=>" + combination);

		if (target.length() == combination.size()) {
			result.add(combination.stream().collect(Collectors.joining()));
			return;
		}

		String targetStr = map.get(target.charAt(startIndex) + "");
		System.out.println(targetStr);
		for (int i = 0; i < targetStr.length(); i++) {
			combination.add(targetStr.charAt(i) + "");
			backtrack(startIndex + 1, combination, target, map, result);

			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {

		phoneKeypadCombinations("69");
	}
}
