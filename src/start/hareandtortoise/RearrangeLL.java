package start.hareandtortoise;

public class RearrangeLL {

	
	static LLNode<Integer> arrange(LLNode<Integer> node) {

		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		LLNode<Integer> pointerOne = node;
		LLNode<Integer> pointerTwo  = reverse(slow);

		while (pointerOne != null && pointerTwo!=null) {
			System.out.println(pointerOne+" "+pointerTwo);
			
			var temp = pointerOne.next;
			pointerOne.next = pointerTwo;
			pointerOne = temp;
			
			temp = pointerTwo.next;
			pointerTwo.next = pointerOne;
			pointerTwo = temp;
		}

		return node;
	}

	static LLNode<Integer> reverse(LLNode<Integer> node) {

		LLNode<Integer> current = node;
		LLNode<Integer> prev = null;

		while (current != null) {
			LLNode<Integer> next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}
	
	public static void main(String[] args) {
		LLNode<Integer> node1 = new LLNode<Integer>(1);

		node1.next = new LLNode<Integer>(2);
		node1.next.next = new LLNode<Integer>(3);
		node1.next.next.next = new LLNode<Integer>(4);
		node1.next.next.next.next = new LLNode<Integer>(5);
		node1.next.next.next.next.next = new LLNode<Integer>(6);

		System.out.println(RearrangeLL.arrange(node1).full());
	}
}
