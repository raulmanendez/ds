package start.ctci.stack;

public class MyStackWithTopBottom {

	private int capacity;
	private Node top,bottom;
	int size;

	public MyStackWithTopBottom(int capacity) {
		this.capacity=capacity;
	}

	public boolean push(int value) {
		if(capacity==size) return false;
		Node n=new Node(value);

		size++;
		if(size==1) bottom=n;
		join(top, n);
		top=n;
		return true;
	}

	private void join(Node n1,Node n2) {
		if(n1!=null) n1.above=n2;
		if(n2!=null) n2.below=n1;
	}

	public int peek() {
		if(top==null) return -1;

		return top.value;
	}

	public int pop() {
		if(top==null) return -1;
		int popped=top.value;

		top=top.below;
		size--;

		return popped;
	}

	public int removeBottom() {
		int removed=bottom.value;
		bottom=bottom.above;
		if(bottom!=null) bottom.below=null;
		size--;
		return removed;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public boolean isFull() {
		return size==capacity;
	}

	class Node {
		private Node above;
		private Node below;
		private int value;

		public Node(int value) {
			this.value=this.value;
		}
	}
}
