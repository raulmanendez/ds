package start;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

	public static Map<Character, Integer> frequency(String s) {
		Map<Character, Integer> fm = new HashMap<>();
		for (char c : s.toCharArray()) {
			fm.put(c, fm.getOrDefault(c, 0) + 1);
		}

		return fm;
	}
	
	public static Map<String, Integer> frequency(List<String> s) {
		Map<String, Integer> fm = new HashMap<>();
		for (String c : s) {
			fm.put(c, fm.getOrDefault(c, 0) + 1);
		}

		return fm;
	}
}
