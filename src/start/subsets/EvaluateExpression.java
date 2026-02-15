package start.subsets;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {

	static List<Integer> waysToEvaluate(String str) {
		List<Integer> result = new ArrayList<>();
		if (!str.isEmpty() && !str.contains("*") && !str.contains("+") && !str.contains("-")) {
			result.add(Integer.parseInt(str));
		} else {

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (!Character.isDigit(ch)) {
					List<Integer> leftParts = waysToEvaluate(str.substring(0, i));
					List<Integer> rightParts = waysToEvaluate(str.substring(i + 1));

					for (int part1 : leftParts) {
						for (int part2 : rightParts) {
							if (ch == '+') {
								result.add(part1 + part2);
							} else if (ch == '-') {
								result.add(part1 - part2);
							} else if (ch == '*') {
								result.add(part1 * part2);
							}

						}

					}

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(waysToEvaluate("2*3-4-5"));
	}
}
