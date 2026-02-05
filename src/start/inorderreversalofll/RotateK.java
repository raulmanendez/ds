package start.inorderreversalofll;

public class RotateK {

	static Node reverse(Node node, int k) {
		if (k <= 1 || node == null | node.next == null)
			return node;

		Node lastNode = node;
		int size = 1;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
			size++;
		}

		lastNode.next = node;// make it circular
		k = k % size;
		int skip = size - k;
		Node lastOfRotatedList = node;
		for (int i = 0; i < skip - 1; i++) {
			lastOfRotatedList = lastOfRotatedList.next;
		}

		node = lastOfRotatedList.next;
		lastOfRotatedList.next = null;

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

		RotateK.reverse(start, 3).print();

	}
}
