package start.ctci.stack;

public class MyQueue<T> {

	private T data;
	private MyQueue<T> next;
	private MyQueue<T> front;
	private MyQueue<T> back;

	public void add(T item) {
		MyQueue<T> newback=new MyQueue<>();
		newback.data=item;

		if(front==null) front=newback;
		if(back!=null) {
			back.next=newback;
		}

		back=newback;
	}

	public T remove() {
		T data=front.data;
		front=front.next;
		if(front==null) back=null;
		return data;
	}

	public T peek() {
		return front.data;
	}

	public boolean isEmpty() {
		return front==null;
	}
}
