package start.linklist;

//Palindrome Linked List: Determine whether a linked list is a palindrome
//(reads the same forwards and backwards).
public class CheckPalindrome {

	public static boolean palindrome(Node head) {

		//first find the middle of the list

		Node slow=head;
		Node fast=head;

		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}

		//now reverse the second half of the list
		Node prev=null,current=slow;
		while(current!=null) {
			Node next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}

		//compare the first and second half
		Node firstHalf=head;
		Node secondHalf=prev;

		while(secondHalf.next!=null) {
			if(firstHalf.data != secondHalf.data) {
				return false;
			} else {
				firstHalf=firstHalf.next;
				secondHalf=secondHalf.next;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		DLinkList list=new DLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(1);

		boolean isPalindrome=palindrome(list.head);
		System.out.println("is list Palindrome::"+isPalindrome);

		list=new DLinkList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);

		isPalindrome=palindrome(list.head);
		System.out.println("is list Palindrome::"+isPalindrome);
	}
}
