package start.ctci.ll;

public class DeleteMiddle {

	public static void deleteNode(LLNode node) {
		if(node==null || node.next==null) return;
		
		node.value=node.next.value;
		node.next=node.next.next;
	}
	
	public static void main(String[] args) {
		LLNode node=LLNode.createDummyNode();
		LLNode end=node;
		while(end.next!=null) {
			end=end.next;
		}
		
		LLNode node4=new LLNode(4);
		end.next=node4;
		
		LLNode node5=new LLNode(5);
		node4.next=node5;
		
		System.out.println("Before Deleting..");
		node.print();
		
		deleteNode(node4);
		
		System.out.println("After Deleting..");
		node.print();
		
		
		
	}
}
