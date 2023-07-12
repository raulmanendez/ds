package start.linklist;

//Find the Middle of a Linked List: Find the middle node of a linked list.
//If the list has an even number of nodes, return the second middle node.
public class MiddleOfLinkedList {

	public static Node findMiddle(Node head) {
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null) {
			
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		DLinkList list=new DLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		Node node=findMiddle(list.head);
		System.out.println("Middle node is::"+node.data);
	}
}
