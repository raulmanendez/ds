package start.hareandtortoise;

public class StartOfCycleInList {

	static LLNode<Integer> hasCycle(LLNode<Integer> node) {

		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow.equals(fast)) {

				LLNode<Integer> current = slow;

				while (true) {
					if (current.next.equals(slow)) {
						return current;
					}
					current = current.next;
				}
			}

		}

		return null;
	}

	public static void main(String[] args) {

		LLNode<Integer> node1 = new LLNode<Integer>(1);

		node1.next = new LLNode<Integer>(2);
		node1.next.next = new LLNode<Integer>(3);
		node1.next.next.next = new LLNode<Integer>(4);
		node1.next.next.next.next = new LLNode<Integer>(5);
		node1.next.next.next.next.next = node1;// cycle

		System.out.println(StartOfCycleInList.hasCycle(node1));
	}
}
