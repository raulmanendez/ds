package start.hareandtortoise;

public class MiddleOfLL {

	static LLNode<Integer> middle(LLNode<Integer> node) {
	
		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	
	public static void main(String[] args) {

		LLNode<Integer> node1 = new LLNode<Integer>(1);

		node1.next = new LLNode<Integer>(2);
		node1.next.next = new LLNode<Integer>(3);
		node1.next.next.next = new LLNode<Integer>(4);
		node1.next.next.next.next = new LLNode<Integer>(5);
		node1.next.next.next.next.next = new LLNode<Integer>(6);
		System.out.println(MiddleOfLL.middle(node1));
		
		node1.next.next.next.next.next.next = new LLNode<Integer>(7);
		System.out.println(MiddleOfLL.middle(node1));
	}
}
