package start.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

	int noRepeat(String s) {

		int maxLength = 0, start = 0;
		Map<Character, Integer> fm = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {

			char endChar = s.charAt(end);
			
			if (fm.containsKey(endChar)) {
				start = end;
				fm.clear();
			}
			fm.put(endChar, 0);

			maxLength = Math.max(maxLength, end - start + 1);
			System.out.println("endChar=>" + endChar + " maxLength=" + maxLength + " fm=>" + fm);
		}

		return maxLength;
	}

	public static void main(String[] args) {

		System.out.println(new NoRepeatSubstring().noRepeat("dvdf"));
	}

}
