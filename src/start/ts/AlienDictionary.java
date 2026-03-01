package start.ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

	static String findOrder(String words[]) {
		if (words == null || words.length == 0)
			return "";

		var inDegree = new HashMap<Character, Integer>();
		var graph = new HashMap<Character, List<Character>>();

		// initialize graph
		for (String word : words)
			for (char character : word.toCharArray()) {
				inDegree.put(character, 0);
				graph.put(character, new ArrayList<>());
			}

		// build graph
		for (int w = 0; w < words.length - 1; w++) {
			String w1 = words[w], w2 = words[w+1];
			
			for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
				
				char parent = w1.charAt(i), child = w2.charAt(i);
				if(parent!=child) {
					inDegree.put(child, inDegree.get(child) + 1);
					graph.get(parent).add(child);
					break;//only first different character is enough
				}
			}
		}

		var sources = new LinkedList<Character>();
		for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
			if (inDegree.get(entry.getKey()) == 0) {
				sources.add(entry.getKey());
			}
		}

		StringBuilder result = new StringBuilder();
		while (!sources.isEmpty()) {
			var vertex = sources.poll();
			result.append(vertex);

			List<Character> children = graph.get(vertex);
			for (Character childVertex : children) {

				inDegree.put(childVertex, inDegree.get(childVertex) - 1);
				if (inDegree.get(childVertex) == 0) {
					sources.add(childVertex);
				}
			}
		}

		if (result.length() != inDegree.size())
			return "";

		return result.toString();
	}

	public static void main(String[] args) {

		System.out.println(findOrder(new String[] { "ba", "bc", "ac", "cab" }));
		System.out.println(findOrder(new String[] { "cab", "aaa", "aab" }));
		System.out.println(findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" }));
	}
}
