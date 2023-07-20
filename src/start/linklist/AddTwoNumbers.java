package start.linklist;

//Add Two Numbers as Linked Lists: 
//Given two linked lists representing two non-negative numbers,
//add them together and return the sum as a linked list.
public class AddTwoNumbers {

	public static Node add(Node head1,Node head2) {
		
		Node result=new Node(0);
		Node current=result;
		
		int carry=0;
		//assuming both have same length
		while(head1!=null) {
			
			int sum=0;
			
			sum+=head1.data;
			sum+=head2.data;
			
			head2=head2.next;
			head1=head1.next;
			
			sum+=carry;
			carry = sum / 10;
			
			current.next=new Node(sum % 10);
			current=current.next;
		}
		
		if(carry>0) {
			current.next=new Node(carry);
			current=current.next;
		}
		
		//result.next as result points to 0
		return result.next;
	}
	
	public static void main(String[] args) {
		
		//number 1 : 563
		Node node11=new Node(3);
		Node node12=new Node(6);
		Node node13=new Node(5);
		
		node11.next=node12;
		node12.next=node13;
		
		//number 1 : 974
		Node node21=new Node(4);
		Node node22=new Node(7);
		Node node23=new Node(9);
		
		node21.next=node22;
		node22.next=node23;
		
		Node result=add(node11, node21);
		node11.print();
		node21.print();
		
		result.print();
	}
}
