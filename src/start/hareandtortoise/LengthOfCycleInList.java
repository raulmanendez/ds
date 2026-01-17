package start.hareandtortoise;

public class LengthOfCycleInList {

	static int cycleLength(LLNode<Integer> node) {

		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;
		
		int length = 0;
		while(fast!=null && fast.next!=null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			length++;
			if(slow.equals(fast)) return length;
			
		}
		
		
		return length;
	}
	
	static int length(LLNode<Integer> slow) {
		int length =0; 
		LLNode<Integer> current = slow;
		while(true) {
			length++;
			current = current.next;
			
			if(current.equals(slow)) break;
		}
		
		return length;
	}

	public static void main(String[] args) {

		LLNode<Integer> node1 = new LLNode<Integer>(1);

		node1.next = new LLNode<Integer>(2);
		node1.next.next = new LLNode<Integer>(3);
		node1.next.next.next = new LLNode<Integer>(4);
		node1.next.next.next.next = new LLNode<Integer>(5);
		node1.next.next.next.next.next = node1.next.next;// cycle - 3
		

		System.out.println(LengthOfCycleInList.cycleLength(node1));
	}
}
