package start.ctci.ll;

public class KthLast {

	public static LLNode KthLastV1(LLNode node, int k) {
		LLNode firstPointer = node;
		while (k != 0) {
			firstPointer = firstPointer.next;
			k--;
		}

		LLNode secondPointer = node;
		while (firstPointer.next != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}

		return secondPointer.next;
	}

	public static int KthLastV2(LLNode node, int k) {
		if(node==null) return 0;
		
		int index=KthLastV2(node.next, k) + 1;
		if(index==k)
			System.out.println("value at kth last is::"+node.value);
		return index;
	}
	
	public static LLNode KthLastV3(LLNode node, int k) {
		Idx idx=new Idx();
		return KthLastV3(node, k, idx);
	}
	
	public static LLNode KthLastV3(LLNode head, int k,Idx idx) {
		if(head==null) return null;
		
		LLNode node=KthLastV3(head.next, k, idx);
		idx.value = idx.value + 1;
		
		if(idx.value==k) {
			return head;
		}
		
		return node;
	}


	public static void main(String[] args) {
		LLNode node = LLNode.createDummyNode();

		LLNode end = node;
		while (end.next != null) {
			end = end.next;
		}

		LLNode node3 = new LLNode(4);
		end.next = node3;

		LLNode node4 = new LLNode(5);
		node3.next = node4;

		LLNode node5 = new LLNode(6);
		node4.next = node5;

		node.print();

		//LLNode result = KthLastV1(node, 4);
		//System.out.println("Kth Node is :" + result.value);

		//KthLastV2(node, 4);
		
		LLNode resultRecursive=KthLastV3(node, 4);
		System.out.println("recursive result::"+resultRecursive.value);

	}
}

class Idx {
	public int value=0;
}