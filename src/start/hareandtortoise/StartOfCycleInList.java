package start.hareandtortoise;

public class StartOfCycleInList {

	static LLNode<Integer> findCycle(LLNode<Integer> node) {

		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow.equals(fast)) {
				int length = findLength(slow);
				return findStart(node, length);
			}

		}

		return null;
	}

	static int findLength(LLNode<Integer> node) {
		LLNode<Integer> current = node;

		int length = 0;
		while (true) {
			current = current.next;
			length++;
			if (node.equals(current))
				break;
		}

		return length;
	}

	static LLNode<Integer> findStart(LLNode<Integer> node, int length) {
		LLNode<Integer> pointerOne = node;
		LLNode<Integer> pointerTwo = node;
		while (length > 0) {
			pointerOne = pointerOne.next;
			length--;
		}

		while (!pointerOne.equals(pointerTwo)) {
			pointerOne = pointerOne.next;
			pointerTwo = pointerTwo.next;
		}

		return pointerOne;
	}

	public static void main(String[] args) {

		LLNode<Integer> node1 = new LLNode<Integer>(1);

		node1.next = new LLNode<Integer>(2);
		node1.next.next = new LLNode<Integer>(3);
		node1.next.next.next = new LLNode<Integer>(4);
		node1.next.next.next.next = new LLNode<Integer>(5);
		node1.next.next.next.next.next = node1.next.next;// cycle of length =34

		System.out.println(StartOfCycleInList.findCycle(node1));
	}
}
