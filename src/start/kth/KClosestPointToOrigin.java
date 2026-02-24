package start.kth;

import java.util.PriorityQueue;
import java.util.Queue;

class Point {

	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int distance() {
		return x * x + y * y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

public class KClosestPointToOrigin {

	static void closest(Point input[], int k) {
		Queue<Point> maxHeap = new PriorityQueue<Point>((a, b) -> b.distance() - a.distance());

		for (int i = 0; i < k; i++)
			maxHeap.add(input[i]);

		for (int i = k; i < input.length; i++) {
			if (input[i].distance() < maxHeap.peek().distance()) {
				maxHeap.poll();
				maxHeap.add(input[i]);
			}
		}

		System.out.println(maxHeap);
	}

	public static void main(String[] args) {
		Point input[] = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };

		closest(input, 2);

		input = new Point[] { new Point(1, 2), new Point(1, 3) };

		closest(input, 1);
	}
}
