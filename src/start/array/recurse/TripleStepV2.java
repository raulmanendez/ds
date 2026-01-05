package start.array.recurse;

import java.util.HashMap;
import java.util.Map;

public class TripleStepV2 {

	static Map<Integer, Integer> memo = new HashMap<>();
	
	static int countSteps(int n) {
		if(n<0) return 0;
		
		if(n==0)  {
			return 1;
		}
		
		if(memo.get(n)!=null) return memo.get(n);
		
		int ways = countSteps(n-1) + countSteps(n-2) + countSteps(n-3);
		
		memo.put(n, ways);
		
		return ways;
	}
	
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		int x = TripleStepV2.countSteps(15);
		System.out.println(System.currentTimeMillis());
		System.out.println(x);
	}
}
