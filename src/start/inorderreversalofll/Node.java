package start.inorderreversalofll;

import java.util.StringJoiner;

public class Node {
	int value;
	Node next;
	
	public Node(int value) {
		super();
		this.value = value;
	}	
	
	public Node(int value, Node next) {
		super();
		this.value = value;
		this.next = next;
	}	
	
	void print() {
		StringJoiner joiner = new StringJoiner(",", "[","]");
		joiner.add(value+"");
		
		Node next = this.next;
		while(next!=null) {
			joiner.add(next.value+"");
			next = next.next;
		}
		
		System.out.println(joiner);
		
	}
}
