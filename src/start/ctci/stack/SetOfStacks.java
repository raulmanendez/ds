package start.ctci.stack;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

	private int capacity;
	private List<MyStackWithTopBottom> stacks;

	public SetOfStacks(int capacity) {
		this.capacity=capacity;
		stacks=new ArrayList<>();
	}

	public void push(int value) {
		MyStackWithTopBottom last=getLastStack();
		if(last!=null && !last.isFull()) {
			last.push(value);
		} else {
			MyStackWithTopBottom stack=new MyStackWithTopBottom(capacity);
			stack.push(value);
			stacks.add(stack);
		}
	}

	public int pop() {
		MyStackWithTopBottom last=getLastStack();
		if(last!=null) {
			int popped=last.pop();
			if(last.size==0) stacks.remove(stacks.size() - 1);
			return popped;
		}

		return 0;
	}

	public int popAt(int index) {
		return shift(index, true);
	}

	public int shift(int index,boolean removeTop) {

		MyStackWithTopBottom stack=stacks.get(index);
		int removed;

		if(removeTop)
			removed=stack.pop();
		else
			removed=stack.removeBottom();

		if(stack.isEmpty()) stacks.remove(index);
		else if(index + 1 < stacks.size()) {
			int popped=shift(index + 1, false);
			stack.push(popped);
		}

		return removed;
	}

	private MyStackWithTopBottom getLastStack() {
		return stacks.get(stacks.size() -1);
	}


}
