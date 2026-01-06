package start.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

	int noRepeat(String s) {

		int maxLength = 0, start = 0;
		Map<Character, Integer> fm = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {

			char endChar = s.charAt(end);
			
			if(fm.containsKey(endChar)) {
			
				start = Math.max(start, fm.get(endChar) + 1);
			}
			
			fm.put(endChar, end);
			
			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {

		System.out.println(new NoRepeatSubstring().noRepeat("dvdf"));
	}

}
