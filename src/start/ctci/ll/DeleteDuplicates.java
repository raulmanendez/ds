package start.ctci.ll;

import java.util.HashSet;

public class DeleteDuplicates {


	public static void deleteDuplicatesV1(LLNode node) {
		HashSet<Integer> set=new HashSet<>();
		LLNode prev=node;
		while(node!=null) {
			if(!set.add(node.value)) {
				prev.next=node.next;
			} else {
				prev=node;
			}

			node=node.next;
		}
	}

	//no buffer allowed
	public static void deleteDuplicatesV2(LLNode node) {
		LLNode current=node;
		while(current!=null) {
			LLNode runner=current;
			while(runner.next!=null) {
				if(runner.next.value==current.value) {
					runner.next=runner.next.next;
				} else {
					runner=runner.next;
				}
			}

			current=current.next;
		}
	}

	public static void main(String[] args) {
		LLNode node=LLNode.createDummyNode();
		System.out.println("Before Deleting..");

		LLNode end=node;
		while(end.next!=null) {
			end=end.next;
		}

		LLNode node3=new LLNode(4);
		end.next=node3;

		LLNode node4=new LLNode(4);
		node3.next=node4;

		LLNode node5=new LLNode(4);
		node4.next=node5;

		node.print();


		System.out.println("After Deleting..");
		//deleteDuplicatesV1(node);
		deleteDuplicatesV2(node);

		node.print();


	}
}
