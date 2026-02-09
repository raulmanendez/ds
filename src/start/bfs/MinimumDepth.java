package start.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {

	static int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int depth=0;

		while (!q.isEmpty()) {
			int levelSize = q.size();
			depth++;
			
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = q.poll();

				if (current.left == null && current.right == null)
					return depth;
				
				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}
		}

		return depth;
	}

	public static void main(String[] args) {
		// 12
		// 7 - 1
		// 10 - 5
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		//root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println(minDepth(root));
	}
}
