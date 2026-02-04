package start.inorderreversalofll;

public class Reverse {

	static Node reverse(Node node, int p, int q) {

		Node prev = null;
		Node current = node;

		for (int i = 0; current != null && i < p - 1; i++) {
			prev = current;
			current = current.next;
		}

		Node lastNodeOfFirstPart = prev;
		Node lastNodeOfSublist = current;

		Node next = null;
		for (int i = 0; current != null && i < q - p + 1; i++) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		if (lastNodeOfFirstPart != null) {
			lastNodeOfFirstPart.next = prev;
		} else {
			node = prev;
		}

		lastNodeOfSublist.next = current;

		return node;
	}

	public static void main(String[] args) {

		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);

		start.print();

		Reverse.reverse(start, 2, 4).print();

	}
}
