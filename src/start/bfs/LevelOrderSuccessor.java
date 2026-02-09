package start.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

	static TreeNode levelSuccessor(TreeNode root, int key) {

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode polled = q.poll();

			if (polled.left != null)
				q.offer(polled.left);

			if (polled.right != null)
				q.offer(polled.right);

			if (polled.value == key && !q.isEmpty()) {
				break;
			}

		}

		return q.peek();
	}

	public static void main(String[] args) {
		// 12-7-1-9-10-5
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		TreeNode result = levelSuccessor(root, 9);
		
		System.out.println(result!=null ? result.value : "NA");
	}
}
