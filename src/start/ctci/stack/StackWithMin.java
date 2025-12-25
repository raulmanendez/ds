package start.ctci.stack;

public class StackWithMin<T> extends MyStack<Integer> {

	private MyStack<Integer> minStack=new MyStack<>();

	@Override
	public void push(Integer item) {
		if(item < min())
			minStack.push(item);

		super.push(item);
	}

	@Override
	public Integer pop() {
		int popped=super.pop();
		if(popped==minStack.peek()) {
			minStack.pop();
		}

		return popped;
	}

	public Integer min() {
		if(minStack.isEmpty())
			return Integer.MAX_VALUE;
		return minStack.peek();
	}
}
