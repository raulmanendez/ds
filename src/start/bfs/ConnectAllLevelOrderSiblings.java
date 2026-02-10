package start.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {

	static void connectSiblings(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		TreeNode prev = null;

		while (!q.isEmpty()) {
			int levelSize = q.size();

			for (int i = 0; i < levelSize; i++) {
				TreeNode current = q.poll();

				if (prev == null)
					result.add(current);
				else
					prev.next = current;

				prev = current;

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}
		}
	}

	static void withoutExtraSpace(TreeNode root) {
		connectSiblings(root);

		TreeNode current = root;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}

	}

	public static void main(String[] args) {
		/*
		 * 12 | 7,1 | 9,10,5 | 20,17
		 */

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);

		withoutExtraSpace(root);

	}
}
