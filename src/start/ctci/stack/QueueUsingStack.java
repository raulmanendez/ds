package start.ctci.stack;

public class QueueUsingStack {

	MyStackWithTopBottom s1,s2;
	
	public QueueUsingStack(int capacity) {
		s1=new MyStackWithTopBottom(capacity);
		s2=new MyStackWithTopBottom(capacity);
	}
	
	public int size() {
		return s1.size + s2.size;
	}
	
	public void add(int item) {
		s1.push(item);
	}
	
	public int peek() {
		shift();
		return s2.peek();
	}

	public int remove() {
		shift();
		return s2.pop();
	}
	
	private void shift() {
		if(s2.isEmpty())
			while(!s1.isEmpty())
				s2.push(s1.pop());
			
	}
}
