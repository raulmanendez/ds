package start.slidingwindow;

import java.util.HashMap;
import java.util.List;

import start.Util;

public class WordsConcatenation {

	String concat(String s, List<String> list) {
		var wordsFrequency = Util.frequency(list);
		var wordLength = list.get(0).length();
		var wordsCount = list.size();
		
		for(int i=0;i< (s.length() - wordsCount * wordsCount) + 1;i++) {
			var wordsSeen = new HashMap<String, Integer>();
			
			for(int j=0;j<wordsCount;j++) {
				int nextWordIndex = i + j * wordLength;
				
				var word = s.substring(nextWordIndex, nextWordIndex + wordLength);
				System.out.println(word);
				
				if(!wordsFrequency.containsKey(word)) {
					break;
				}
				
				wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
				
				if(wordsSeen.get(word) > wordsFrequency.get(word)) {
					break;
				}
				
				
				if(j + 1 == list.size()) {
					return i+"";
				}
			}
		}
		
		return "NA";
	}
	
	public static void main(String[] args) {
		var c = new WordsConcatenation();
		
		
		System.out.println(
		c.concat("catcatfoxfox", List.of("cat","fox"))
				);
	}

}
