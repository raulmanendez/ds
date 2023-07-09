package start.linklist;

import java.util.StringJoiner;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data=data;
	}
}

public class DLinkList {

	Node head=null;
	
	void add(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		} else {
			Node current=head;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=newNode;
		}
	}
	
	void display() {
		Node current=head;
		StringJoiner joiner=new StringJoiner(",", "[", "]");
		
		while(current!=null) {
			joiner.add(String.valueOf(current.data));
			current=current.next;
		}
		
		System.out.println(joiner);
	}
	
	void reverse() {
		Node current=head;
		Node next=null;
		Node prev=null;
		
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}
	
	//"Floyd's Cycle Detection" 
	//tortoise and hare
	//create a cycle to test list.head.next=list.head;
	boolean hasCycle() {
		if(head==null || head.next==null) {
			return false;
		}
		
		Node fast=head;
		Node slow=head;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		
		return false;
	}	
}
