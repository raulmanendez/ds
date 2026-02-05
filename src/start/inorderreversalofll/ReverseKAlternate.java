package start.inorderreversalofll;

public class ReverseKAlternate {

	static Node reverse(Node node, int k) {
		if (k <= 1 || node == null)
			return node;

		Node prev = null;
		Node current = node;

		while (true) {

			Node lastNodeOfPreviousPart = prev;
			Node lastNodeOfSubList = current;

			Node next = null;
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}

			if (lastNodeOfPreviousPart != null) {
				lastNodeOfPreviousPart.next = prev;
			} else {
				node = prev;
			}

			lastNodeOfSubList.next = current;
			
			for(int i=0;i< k && current!=null;i++) {
				prev= current;
				current = current.next;
			}
			
			if (current == null)
				break;
		}

		return node;
	}

	public static void main(String[] args) {

		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);
		start.next.next.next.next.next = new Node(6);
		start.next.next.next.next.next.next = new Node(7);
		start.next.next.next.next.next.next.next = new Node(8);

		start.print();

		ReverseKAlternate.reverse(start, 2).print();

	}
}
