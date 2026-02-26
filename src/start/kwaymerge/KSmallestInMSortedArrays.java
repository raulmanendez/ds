package start.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

import start.hareandtortoise.LLNode;

public class KSmallestInMSortedArrays {

	private static class Node {
		int elementIndex, arrayIndex;

		Node(int elementIndex, int arrayIndex) {
			this.elementIndex = elementIndex;
			this.arrayIndex = arrayIndex;
		}
	}

	static int findKthSmallest(List<Integer[]> input, int k) {

		var mh = new PriorityQueue<Node>((a, b) -> {
			return input.get(a.arrayIndex)[a.elementIndex] - input.get(b.arrayIndex)[b.elementIndex];
		});

		for (int i = 0; i < input.size(); i++)
			if (input.get(i) != null) {
				mh.add(new Node(0, i));
			}

		int numberCount = 0, result = 0;
		while (!mh.isEmpty()) {
			var node = mh.poll();

			result = input.get(node.arrayIndex)[node.elementIndex];
			if (++numberCount == k)
				break;

			node.elementIndex++;

			if (input.get(node.arrayIndex).length > node.elementIndex)
				mh.add(node);
		}

		return result;
	}

	public static void main(String[] args) {
		Integer ll1[] = new Integer[] {2,6,8};
		Integer ll2[] = new Integer[] {3,6,7};
		Integer ll3[] = new Integer[] {1,3,4};


		System.out.println(findKthSmallest(List.of(ll1,ll2,ll3), 5));//4
	}
}
