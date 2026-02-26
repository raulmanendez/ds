package start.hareandtortoise;

import java.util.StringJoiner;

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
	
	public String full() {
		StringJoiner sj= new StringJoiner("->");
		sj.add(value.toString());
		LLNode<T> current = next;
		while(current!=null) {
			sj.add(current.value.toString());
			current= current.next;
		}
		
		return sj.toString();
	}
}
