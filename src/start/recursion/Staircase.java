package start.recursion;

public class Staircase {

	public static int ways(int steps,int start) {
		if(start==steps) return 1;

		int result=0;

		result+=ways(steps, start+1);
		if(start+2 <= steps) result+=ways(steps, start+2);
		if(start+3 <= steps) result+=ways(steps, start+3);

		return result;
	}

	public static void main(String[] args) {

		System.out.println("Number of ways are::"+ways(4, 0));
	}
}
