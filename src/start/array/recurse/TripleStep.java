package start.array.recurse;

import java.util.Arrays;
import java.util.HashMap;

public class TripleStep {

	private int countSteps(int n) {
		return countStepsRecurse(n, 0);
	}

	private int countStepsMemoization(int n) {
		return countStepsRecurseMemoization(n, 0);
	}

	private int countStepsRecurse(int n,int currentPos) {
		timesWOMemoization++;

		if(currentPos>n)
			return 0;
		else if(currentPos==n)
			return 1;

		return countStepsRecurse(n,currentPos+1) +
				countStepsRecurse(n,currentPos+2) +
				countStepsRecurse(n,currentPos+3);
	}

	static int timesWOMemoization=0;
	static int timesMemoization=0;
	static HashMap<Integer, Integer> map=new HashMap<>();
	private int countStepsRecurseMemoization(int n,int currentPos) {
		timesMemoization++;
		if(currentPos>n)
			return 0;
		else if(currentPos==n)
			return 1;

		int pos1Ways=0;
		if(map.get(currentPos + 1)==null) {
			pos1Ways=countStepsRecurseMemoization(n,currentPos + 1);
			map.put(currentPos + 1, pos1Ways);
		} else {
			pos1Ways=map.get(currentPos + 1);
		}

		int pos2Ways=0;
		if(map.get(currentPos + 2)==null) {
			pos2Ways=countStepsRecurseMemoization(n,currentPos + 2);
			map.put(currentPos + 2, pos2Ways);
		} else {
			pos2Ways=map.get(currentPos + 2);
		}


		int pos3Ways=0;
		if(map.get(currentPos + 3)==null) {
			pos3Ways=countStepsRecurseMemoization(n,currentPos + 3);
			map.put(currentPos + 3, pos3Ways);
		} else {
			pos3Ways=map.get(currentPos + 3);
		}

		return pos1Ways + pos2Ways + pos3Ways;
	}

	private int countWays(int n) {
		timesWOMemoization++;
		if(n < 0) {
			return 0;
		} else if(n==0) {
			return 1;
		} else {
			return countWays(n -1) +countWays(n -2) +countWays(n -3);
		}
	}

	private int countWaysMemo(int n) {
		timesMemoization=0;
		int memo[]=new int[n + 1];
		Arrays.fill(memo, -1);

		return countWaysMemo(n, memo);
	}

	private int countWaysMemo(int n,int memo[]) {
		timesMemoization++;
		if(n < 0) {
			return 0;
		} else if(n==0) {
			return 1;
		} else if(memo[n] > -1) {
			return memo[n];
		} else {
			memo[n]= countWaysMemo(n -1,memo) +countWaysMemo(n -2,memo) +countWaysMemo(n -3,memo);
			return memo[n];
		}
	}


	public static void main(String[] args) {

		TripleStep test=new TripleStep();

		int n=26;
		int ways=test.countSteps(n);

		System.out.println("total ways="+ways);

		System.out.println("total ways="+ways+" and called times countSteps:"+timesWOMemoization);

		timesWOMemoization=0;
		ways=test.countWays(n);

		System.out.println("total ways="+ways+" and called times countWays:"+timesWOMemoization);


		ways=test.countStepsMemoization(n);

		System.out.println("total ways using memoization="+ways+" and called times countStepsMemoization:"+timesMemoization);

		ways=test.countWaysMemo(n);

		System.out.println("total ways using memoization other="+ways+" and called times countWaysMemo:"+timesMemoization);

	}
}
