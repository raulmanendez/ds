package start.linklist;

public class LinkListOperations {

	public static void main(String[] args) {
		DLinkList list=new DLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println("Before Reverse::");
		list.display();
		
		System.out.println("After Reverse::");
		list.reverse();
		list.display();
		
		System.out.println("List has cycle::"+list.hasCycle());
		
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
		
		DLinkList merged=DLinkList.mergeList(list1, list2);
		merged.display();
	}
}
