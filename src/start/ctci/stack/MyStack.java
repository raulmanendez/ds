package start.ctci.stack;

public class MyStack<T> {
	private T data;
	private MyStack<T> top;
	private MyStack<T> next;


	public void push(T item) {
		MyStack<T> newTop=new MyStack<>();
		newTop.data=item;
		newTop.next=top;
		top=newTop;
	}

	public T pop() {
		T data=top.data;
		top=top.next;
		return data;
	}

	public T peek() {
		return top.data;
	}

	public boolean isEmpty() {
		return top==null;
	}
}
