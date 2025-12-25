package start.ctci.stack;

public class StackQueueTest {

	public static void main(String[] args) {
		MyStack<Integer> stack=new MyStack();

		stack.push(1);
		System.out.println(stack.peek());

		stack.push(2);
		System.out.println(stack.peek());

		stack.push(3);
		System.out.println(stack.peek());

		int popped=stack.pop();
		System.out.println(popped+" peek :"+stack.peek());

		System.out.println(stack.isEmpty());

		stack.pop();
		stack.pop();

		System.out.println(stack.isEmpty());

		System.out.println("Queue Started...");


		MyQueue<Integer> q=new MyQueue<>();
		q.add(1); System.out.println("front:"+q.peek());
		q.add(2); System.out.println("front:"+q.peek());
		q.add(3); System.out.println("front:"+q.peek());

		q.remove(); System.out.println("front:"+q.peek());

	}
}
