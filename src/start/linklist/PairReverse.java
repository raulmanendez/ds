package start.linklist;

public class PairReverse {

	
	static void reverse(Node node) {
		node.print();
		
		Node prev = node;
		Node current = node.next;
		node = current;
		while(true) {
			Node next= current.next;
			current.next = prev;
			
			if(next==null || next.next==null) {
				prev.next = next;
				break;
			}
			
			prev.next = next.next;
			
			prev = next;
			current = next.next;
			
			node.print();
		}
		
		node.print();
	}
	
	public static void main(String[] args) {
		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);
		start.next.next.next.next.next = new Node(6);
		
		
		PairReverse.reverse(start);
		
	}
}
