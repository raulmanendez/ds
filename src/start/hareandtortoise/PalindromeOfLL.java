package start.hareandtortoise;

public class PalindromeOfLL {

	static boolean isPalindrome(LLNode<Integer> node) {

		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		LLNode<Integer> reversed = reverse(slow);
		slow = node;

		while (slow != null && reversed != null) {
			if (!slow.equals(reversed))
				return false;

			slow = slow.next;
			reversed = reversed.next;
		}

		return true;
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
		node1.next.next.next = new LLNode<Integer>(3);
		node1.next.next.next.next = new LLNode<Integer>(2);
		node1.next.next.next.next.next = new LLNode<Integer>(1);

		System.out.println(PalindromeOfLL.isPalindrome(node1));

		LLNode<Integer> node2 = new LLNode<Integer>(1);

		node2.next = new LLNode<Integer>(2);
		node2.next.next = new LLNode<Integer>(3);
		node2.next.next.next = new LLNode<Integer>(4);
		node2.next.next.next.next = new LLNode<Integer>(3);
		node2.next.next.next.next.next = new LLNode<Integer>(2);
		node2.next.next.next.next.next.next = new LLNode<Integer>(1);

		System.out.println(PalindromeOfLL.isPalindrome(node2));
	}
}
