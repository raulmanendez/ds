package start.linklist;

public class MergeTwoSortedList {

	static DLinkList mergeList(DLinkList first,DLinkList second) {
		DLinkList merged=new DLinkList();
		
		Node firstHead=first.head;
		Node secondHead=second.head;
		
		while(firstHead!=null && secondHead!=null) {
			if(firstHead.data < secondHead.data) {
				merged.add(firstHead.data);
				firstHead=firstHead.next;
			} else {
				merged.add(secondHead.data);
				secondHead=secondHead.next;
			}
		}
		
		while(firstHead!=null) {
			merged.add(firstHead.data);
			firstHead=firstHead.next;
		}
		
		while(secondHead!=null) {
			merged.add(secondHead.data);
			secondHead=secondHead.next;
		}
		
		return merged;
	}
	
	public static void main(String[] args) {
		System.out.println("After merging sorted lists::");
		DLinkList list1=new DLinkList();
		list1.add(5);
		list1.add(15);
		list1.add(25);
		list1.add(35);
		
		DLinkList list2=new DLinkList();
		list2.add(11);
		list2.add(22);
		list2.add(33);
		list2.add(44);
		list2.add(55);
		
		DLinkList merged=mergeList(list1, list2);
		merged.display();
	}
}
