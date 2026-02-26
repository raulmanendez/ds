package start.kwaymerge;

import java.util.PriorityQueue;

import start.hareandtortoise.LLNode;

public class MergeKSortedArrays {

	static LLNode<Integer> merge(LLNode<Integer>[] input) {

		var mh = new PriorityQueue<LLNode<Integer>>((a, b) -> {
			return a.value - b.value;
		});

		for (LLNode<Integer> node : input)
			if (node != null)
				mh.add(node);

		LLNode<Integer> head = null, tail = null;
		while (!mh.isEmpty()) {

			var polled = mh.poll();
			if (head == null) {
				head = tail = polled;
			} else {
				tail.next = polled;
				tail = polled;
			}

			if (polled.next != null)
				mh.add(polled.next);

		}

		return head;
	}

	public static void main(String[] args) {
		var ll1 = new LLNode<Integer>(2);
		ll1.next = new LLNode<Integer>(6);
		ll1.next.next = new LLNode<Integer>(8);

		var ll2 = new LLNode<Integer>(3);
		ll2.next = new LLNode<Integer>(6);
		ll2.next.next = new LLNode<Integer>(7);

		var ll3 = new LLNode<Integer>(1);
		ll3.next = new LLNode<Integer>(3);
		ll3.next.next = new LLNode<Integer>(4);
		
		System.out.println(
				merge(new LLNode[] {ll1, ll2, ll3}).full()
				);//1->2->3->3->4->6->6->7->8
	}
}
