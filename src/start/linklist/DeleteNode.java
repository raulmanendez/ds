package start.linklist;


//Delete Node in a Linked List:
//Delete a given node from a linked list (the given node is not the tail).
public class DeleteNode {

	public static void delete(Node head,Node node) {
		
		System.out.println("Node data to delete::"+node.data);
		
		if(head==node) {
			
			if(head.next==null) {
				head=null;
			} else {
				head.data=head.next.data;
				head.next=head.next.next;
			}
			
			return;
		}
		
		
		Node current=head;
		while(current.next!=null && current.next!=node) {
			current=current.next;
		}
		
		System.out.println("Previous to the node to be deleted is::"+current.data);
		
		current.next=current.next.next;
	}
	
	public static void main(String[] args) {
		
		Node first=new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		Node fourth=new Node(4);
		
		first.next=second;
		second.next=third;
		third.next=fourth;
		
		System.out.println("Before deletion::");
		first.print();
		
		System.out.println("After deletion::");
		delete(first,second);
		first.print();
	}
}
