package start.hareandtortoise;

public class LLNode<T> {
	public T value;
	public LLNode<T> next;

	public LLNode(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return value.equals(((LLNode<T>)obj).value);
	}
}
