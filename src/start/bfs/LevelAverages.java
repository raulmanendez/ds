package start.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverages {

	static List<Double> levelTraversal(TreeNode root) {
		List<Double> result = new LinkedList<>();
		if (root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();
			double sum = 0;

			for (int i = 0; i < levelSize; i++) {
				TreeNode current = q.poll();

				sum += current.value;

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}

			result.add(sum/levelSize);
		}

		return result;
	}

	public static void main(String[] args) {
		// 12 7-1 9-10-5
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println(levelTraversal(root));
	}
}
