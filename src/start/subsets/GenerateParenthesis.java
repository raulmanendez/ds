package start.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {

	static class PString {
		String str;
		int openCount;
		int closedCount;
		
		public PString(String str, int openCount, int closedCount) {
			super();
			this.str = str;
			this.openCount = openCount;
			this.closedCount = closedCount;
		}
	}
	
	static List<String> generate(int n) {
		List<String> result = new ArrayList<>();
		Queue<PString> q= new LinkedList<>();
		q.add(new PString("", 0, 0));
		
		while(!q.isEmpty()) {
			PString polled = q.poll();
			
			if(polled.openCount==n && polled.closedCount==n) {
				result.add(polled.str);
			} else {
			
				if(polled.openCount < n) {
					q.add(new PString(polled.str+"(", polled.openCount+1, polled.closedCount));
				}
				
				if(polled.openCount > polled.closedCount) {
					q.add(new PString(polled.str+")", polled.openCount, polled.closedCount + 1));
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(
				generate(3)
				);
	}
}
