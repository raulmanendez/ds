package start.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationInAString {

	boolean has(String s, String pattern) {
		var pMap = map(pattern);

		List<Integer> result = new ArrayList<>();

		int start = 0, matched = pMap.size();
		for (int end = 0; end < s.length(); end++) {

			char endChar = s.charAt(end);

			if (pMap.containsKey(endChar)) {
				pMap.put(endChar, pMap.get(endChar) - 1);

				if (pMap.get(endChar) == 0)
					matched++;
			}

			if (matched == pMap.size())
				result.add(start);

			if(end - start + 1 > pattern.length()) {
				char startChar = s.charAt(start);
				start++;
				
				if (pMap.containsKey(startChar)) {//don't do anything if end char not valid in window
					if (pMap.get(startChar) == 0)
						matched++;
					
					pMap.put(startChar, pMap.get(startChar) + 1);
				}
			}
		}

		System.out.println(result);
		return !result.isEmpty();
	}

	Map<Character, Integer> map(String s) {
		Map<Character, Integer> fm = new HashMap<>();
		for (char c : s.toCharArray()) {
			fm.put(c, fm.getOrDefault(c, 0) + 1);
		}

		return fm;
	}

	public static void main(String[] args) {
		var p = new PermutationInAString();

		System.out.println(p.has("oibcaf", "abc"));
		System.out.println(p.has("odicf", "dc"));
		System.out.println(p.has("eidbaooo", "ab"));
		System.out.println(p.has("abcde", "abc"));
		System.out.println(p.has("eidbaooo", "ab"));
		System.out.println(p.has("aab", "aaa"));
	}
}
