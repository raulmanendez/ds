package start.ctci.ll;

import java.util.StringJoiner;

public class LLNode {

	int value;
	LLNode next;

	public LLNode(int value) {
		this.value=value;
	}

	public LLNode(LLNode node) {
		this.value=node.value;
		this.next=node.next;
	}

	public LLNode(int value,LLNode next) {
		this.value=value;
		this.next=next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LLNode getNext() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}


	public void print() {
		int count=10;//to avoid recursion
		LLNode current=this;
		StringJoiner joiner=new StringJoiner(",","[","]");
		while(current!=null) {
			joiner.add(current.getValue()+"");

			current=current.next;

			if(count--==0) break;
		}

		System.out.println(joiner.toString());
	}

	public static LLNode createDummyNode() {
		LLNode node1=new LLNode(1);
		LLNode node2=new LLNode(2);
		LLNode node3=new LLNode(3);

		node1.next=node2;
		node2.next=node3;

		return node1;

	}

	public static void main(String[] args) {
		LLNode node1=createDummyNode();

		node1.print();
	}

}
