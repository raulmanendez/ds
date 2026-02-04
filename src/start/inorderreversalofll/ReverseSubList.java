package start.inorderreversalofll;

public class ReverseSubList {

	static Node reverse(Node node) {

		Node prev = null;
		Node current = node;
		while(current!=null) {
			Node next = current.next;
			current.next =  prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		
		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);
		
		start.print();
		
		ReverseSubList.reverse(start).print();
				
		
	}
}
