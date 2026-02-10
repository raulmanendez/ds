package start.dfs;

import start.bfs.TreeNode;

public class PathSum {

	static boolean hasSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (sum == root.value && root.left == null && root.right == null)
			return true;

		return hasSum(root.left, sum - root.value) || hasSum(root.right, sum - root.value);
	}

	public static void main(String[] args) {

		/*
		 * 1 2, 3 4,5 6,7
		 * 
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(hasSum(root, 11));
	}
}
