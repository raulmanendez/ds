package start.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

	static List<List<Integer>> levelTraversal(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;

		boolean leftToRight = true;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);

			for (int i = 0; i < levelSize; i++) {
				TreeNode current = q.poll();

				if(leftToRight)
					currentLevel.add(current.value);
				else
					currentLevel.add(0, current.value);

				if (current.left != null)
					q.offer(current.left);

				if (current.right != null)
					q.offer(current.right);
			}
			
			leftToRight= !leftToRight;
			result.add(currentLevel);
		}

		return result;
	}

	public static void main(String[] args) {
		/*
		 * 12
		 * 1, 7
		 * 9, 10, 5
		 * 17, 20
		 */
		
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);

		System.out.println(levelTraversal(root));
	}
}
