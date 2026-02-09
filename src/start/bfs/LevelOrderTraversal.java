package start.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	static List<List<Integer>> levelTraversal(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);

			for (int i = 0; i < levelSize; i++) {
				TreeNode current = q.poll();

				currentLevel.add(current.value);

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}

			result.add(currentLevel);
		}

		return result;
	}

	public static void main(String[] args) {
		// 12-7-1-9-10-5
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println(levelTraversal(root));
	}
}
