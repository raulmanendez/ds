package start.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {

	private static class Entry {
		int arrayIndex, elementIndex;

		Entry(int arrayIndex, int elementIndex) {
			this.arrayIndex = arrayIndex;
			this.elementIndex = elementIndex;
		}
	}

	static int[] get(List<Integer[]> lists) {
		var mh = new PriorityQueue<Entry>((a, b) -> {
			return lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex];
		});

		int start = 0, end = Integer.MAX_VALUE, currentMaxNUmber = Integer.MIN_VALUE;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				mh.add(new Entry(i, 0));
				currentMaxNUmber = Math.max(currentMaxNUmber, lists.get(i)[0]);
			}

		}

		while (mh.size() == lists.size()) {
			var polled = mh.poll();

			if(end - start >  currentMaxNUmber - lists.get(polled.arrayIndex)[polled.elementIndex]) {
				start =  lists.get(polled.arrayIndex)[polled.elementIndex];
				end = currentMaxNUmber;
			}

			polled.elementIndex++;

			if (polled.elementIndex < lists.get(polled.arrayIndex).length) {
				mh.add(polled);
				currentMaxNUmber = Math.max(currentMaxNUmber, lists.get(polled.arrayIndex)[polled.elementIndex]);
			}
		}

		System.out.println(start + "-"+ end );
		return new int[] {start, end};
	}

	public static void main(String[] args) {

		Integer ll1[] = new Integer[] { 1, 5, 8 };
		Integer ll2[] = new Integer[] { 4, 12 };
		Integer ll3[] = new Integer[] { 7, 8, 10 };

		get(List.of(ll1, ll2, ll3));// [4-7]
	}
}
