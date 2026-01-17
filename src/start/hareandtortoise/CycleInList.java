package start.hareandtortoise;

public class CycleInList {

	static boolean hasCycle(LLNode<Integer> node) {

		LLNode<Integer> slow = node;
		LLNode<Integer> fast = node;
		
		
		while(fast!=null && fast.next!=null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			
			if(slow.value==fast.value) return true;
			
		}
		
		
		return false;
	}

	public static void main(String[] args) {

		LLNode<Integer> node1 = new LLNode<Integer>(1);

		node1.next = new LLNode<Integer>(2);
		node1.next.next = new LLNode<Integer>(3);
		node1.next.next.next = new LLNode<Integer>(4);
		node1.next.next.next.next = new LLNode<Integer>(5);
		node1.next.next.next.next.next = node1;// cycle
		

		System.out.println(CycleInList.hasCycle(node1));
		node1.next.next.next.next.next = null;// no cycle
		System.out.println(CycleInList.hasCycle(node1));
	}
}
