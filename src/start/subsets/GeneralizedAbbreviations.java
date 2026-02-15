package start.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralizedAbbreviations {

	static class AWord {
		StringBuilder str;
		int start;
		int count;

		public AWord(StringBuilder str, int start, int count) {
			super();
			this.str = str;
			this.start = start;
			this.count = count;
		}

		@Override
		public String toString() {
			return "AWord [str=" + str + ", start=" + start + ", count=" + count + "]";
		}
	}

	static List<String> generate(String str) {
		int wordLen = str.length();
		List<String> result = new ArrayList<>();
		Queue<AWord> q = new LinkedList<>();
		q.add(new AWord(new StringBuilder(), 0, 0));
		
		while(!q.isEmpty()) {
			System.out.println(q);
			System.out.println("result => "+result);
			
			AWord polled = q.poll();
			if(polled.start==wordLen) {
				if(polled.count!=0)
					polled.str.append(polled.count);
				
				result.add(polled.str.toString());
			} else {
				
				q.add(new AWord(new StringBuilder(polled.str), polled.start + 1, polled.count + 1));
				
				if(polled.count!=0)
					polled.str.append(polled.count);
				
				q.add(new AWord(new StringBuilder(polled.str)
						.append(str.charAt(polled.start))
						
						, polled.start + 1, 0));
				
			}
			
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(generate("BAT"));
	}
}
