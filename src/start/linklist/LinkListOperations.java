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
	}
}
