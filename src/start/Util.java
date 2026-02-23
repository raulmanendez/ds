package start;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Util {

	public static void print(int its[][]) {
		StringJoiner joiner = new StringJoiner(",", "[", "]");
		for(int arr[]:its) {
			StringJoiner innerjoiner = new StringJoiner(",", "[", "]");
			joiner.add("\n");
			for(int element:arr) {
				innerjoiner.add(element+"");
			}
			
			joiner.add(innerjoiner.toString());
		}
		System.out.println(joiner);
	}
	
	public static void print(int its[]) {
		StringJoiner joiner = new StringJoiner(",", "[", "]");
		for(Object it:its) {
			joiner.add(it.toString());
		}
		System.out.println(joiner);
	}
	
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
