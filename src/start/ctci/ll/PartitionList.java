package start.ctci.ll;

public class PartitionList {

	public static LLNode partition(LLNode node,int x) {
		LLNode head=node;
		LLNode tail=node;
		
		while(node!=null ) {
			LLNode next=node.next;
			
			if(node.value < x) {
				node.next=head;
				head=node;
				
			} else {
				tail.next=node;
				tail=node;
			}
			
			node=next;
		}
		tail.next=null;
		
		return head;
	}
	
	public static void main(String[] args) {
		LLNode node1=new LLNode(3);
		
		LLNode node2=new LLNode(5);
		node1.next=node2;
		
		LLNode node3=new LLNode(8);
		node2.next=node3;
		
		LLNode node4=new LLNode(5);
		node3.next=node4;
		
		LLNode node5=new LLNode(10);
		node4.next=node5;
		
		LLNode node6=new LLNode(2);
		node5.next=node6;
		
		LLNode node7=new LLNode(1);
		node6.next=node7;
		
		System.out.println("Before Partition..");
		node1.print();
		
		LLNode newHead=partition(node1,5);
		
		System.out.println("After Partition new head..");
		newHead.print();
		
		
		
	}
}
