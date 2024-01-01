package start.ctci.stack;

import java.util.StringJoiner;

public class SortAStack {

	public static void sort(MyStack<Integer> stack) {
		MyStack<Integer> temp=new MyStack<>();
		while(!stack.isEmpty()) {
			int removed=stack.pop();
			while(!temp.isEmpty() && temp.peek() > removed) {
				stack.push(temp.pop());
			}
			temp.push(removed);
		}
		
		while(!temp.isEmpty())
			stack.push(temp.pop());
	}
	
	
	public static void main(String[] args) {
		
		MyStack<Integer> stack=new MyStack<Integer>();
		stack.push(10);
		stack.push(1);
		stack.push(11);
		stack.push(4);
		stack.push(16);
		
		sort(stack);
		
		StringJoiner joiner=new StringJoiner(","); 
		while(!stack.isEmpty()) {
			joiner.add(stack.pop()+"");
		}
		
		System.out.println(joiner);
		
	}
}
