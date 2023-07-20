package start.linklist;

//Remove Duplicates from Sorted List: Remove duplicates from a sorted linked list,
//retaining only distinct values.
public class RemoveDuplicates {

	public static Node removeDuplicates(Node head) {
		
		Node current=head;
		
		while(current.next!=null) {
			
			System.out.println("current::"+current.data+" next ::"+current.next.data);
			
			if(current.data == current.next.data) {
				System.out.println("EQUAL");
				current.next=current.next.next;
			} else {
				current=current.next;
			}
			
			System.out.println("current after::"+current.data);
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		DLinkList list=new DLinkList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		
		removeDuplicates(list.head);
		System.out.println("After removing duplicates::");
		list.display();
	}
}
