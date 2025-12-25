package start.array.recurse;

import java.util.Stack;

public class TowerOfHanoi {

	public void toh(int n,Stack<Integer> source,Stack<Integer> destination,Stack<Integer> buffer) {
		if(n==0) {
			return;
		}
		toh(n-1, source, buffer, destination);

		destination.push(source.pop());

		toh(n-1, buffer, destination, source);
	}

	public static void main(String[] args) {
		TowerOfHanoi test=new TowerOfHanoi();

		Stack<Integer> stack=new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);

		Stack<Integer> buffer=new Stack<>();
		Stack<Integer> destination=new Stack<>();

		test.toh(stack.size(), stack, buffer, destination);


		System.out.println(stack+" "+buffer+" "+destination);
	}
}
