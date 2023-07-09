package start.linklist;

public class RemoveNthFromEnd {

	static Node removeNthNodeFromEnd(Node head,int n) {
		Node slow=head;
		Node fast=head;
		
		int count=0;
		while(count<=n && fast!=null) {
			fast=fast.next;
			count++;
		}
		
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		
		slow.next=slow.next.next;
		
		return slow;
	}
	
	public static void main(String[] args) {
		DLinkList list=new DLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println("Before Removing::");
		list.display();
		
		removeNthNodeFromEnd(list.head, 3);//3
		
		System.out.println("After Removing::"+list.head.data);
		list.display();
		
		
	}
}
