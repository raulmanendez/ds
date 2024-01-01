package start.ctci.stack;

public class FixedMultiStack {
	private int stacks=3;
	private int size;
	private int values[];
	private int sizes[];
	
	
	public FixedMultiStack(int size) {
		this.size=size;
		sizes=new int[stacks];
		values=new int[size * stacks];
	}

	public void push(int stackNo,int value) {
		if(isFull(stackNo)) {
			System.out.println("Stack is full.");
			return;
		}
			
		int index=getIndexOfTop(stackNo);
		values[index]=value;
		sizes[stackNo -1]++;
	}

	public int pop(int stackNo) {
		if(isEmpty(stackNo)) {
			System.out.println("Stack is empty.");
			return -1;
		}
		
		int index=getIndexOfTop(stackNo) - 1;
		int popped=values[index];
		
		values[index]=0;
		sizes[stackNo-1]--;
		
		return popped;

	}

	public int peek(int stackNo) {
		if(isEmpty(stackNo)) {
			System.out.println("Stack is empty.");
			return -1;
		}
		
		int index=getIndexOfTop(stackNo);
		int value=values[index-1];
		
		return value;
	}
	
	private int getIndexOfTop(int stackNo) {
		int stackSize=sizes[stackNo - 1];
		int offset=(stackNo - 1) * size;
		
		return stackSize + offset;
	}
	
	private boolean isFull(int stackNo) {
		return sizes[stackNo-1]==this.size;
	}
	
	private boolean isEmpty(int stackNo) {	
		return sizes[stackNo-1]==0;
	}

	public void print() {
		StringBuilder builder=new StringBuilder();
		builder.append("Stack 1: Size: ");
		builder.append(sizes[0]+" -> ");
		int start=0,end=size;
		while(start<end) {
			builder.append(values[start]);
			builder.append(",");
			start++;
		}
		
		builder.append("\n");
		
		//2
		builder.append("Stack 2: Size: ");
		builder.append(sizes[1]+" -> ");
		start=size;end=size * 2;
		while(start<end) {
			builder.append(values[start]);
			builder.append(",");
			start++;
		}
		
		builder.append("\n");
		
		//2
		builder.append("Stack 3: Size: ");
		builder.append(sizes[2]+" -> ");
		start=size*2;end=size * 3;
		while(start<end) {
			builder.append(values[start]);
			builder.append(",");
			start++;
		}
		
		
		System.out.println(builder);
	}
	
	public static void main(String[] args) {
		FixedMultiStack stack=new FixedMultiStack(6);
		
		stack.push(1, 1);
		stack.push(2, 2);
		stack.push(3, 3);
		
		
		stack.push(2, 4);
		stack.push(2, 5);
		stack.push(1, 6);
		
		stack.print();
		
		System.out.println("peek 3:"+stack.peek(3));
		System.out.println("peek 2:"+stack.peek(2));
		System.out.println("peek 1:"+stack.peek(1));
		
		
		System.out.println("popping 2 : "+stack.pop(2));
		System.out.println("after popping peek 2:"+stack.peek(2));
		
		System.out.println("popping 3 : "+stack.pop(3));
		System.out.println("popping 3 : "+stack.pop(3));
		
		
		stack.push(2,7);
		stack.push(2,8);
		stack.push(2,9);
		stack.push(2,10);
		stack.push(2,11);
		
		stack.print();
		
	}
	
}
