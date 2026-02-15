package start.subsets;

import java.util.ArrayList;
import java.util.List;

public class StringChangeCasePermutations {

	static List<String> permutations(String s) {
		List<String> permutations = new ArrayList<>();
		if (s == null)
			return permutations;

		permutations.add(s);

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				int n = permutations.size();
				for (int j = 0; j < n; j++) {
					char[] arr = permutations.get(j).toCharArray();

					if (Character.isUpperCase(arr[i])) {
						arr[i] = Character.toLowerCase(arr[i]);
					} else {
						arr[i] = Character.toUpperCase(arr[i]);
					}

					permutations.add(new String(arr));
				}

			}

		}

		return permutations;
	}

	public static void main(String[] args) {
		System.out.println(permutations("st45c"));
	}
}
