package start.dfs;

import start.bfs.TreeNode;

public class MaximumPathSum {

	static int maximumPathSum = Integer.MIN_VALUE;

	static int sum(TreeNode root) {
		findMaxSumRecursive(root);
		return maximumPathSum;
	}

	static int findMaxSumRecursive(TreeNode current) {
		if (current == null)
			return 0;

		int leftSum = findMaxSumRecursive(current.left);
		int rightSum = findMaxSumRecursive(current.right);

		leftSum = Math.max(leftSum, 0);
		rightSum = Math.max(rightSum, 0);

		int currentSum = leftSum + rightSum + current.value;

		maximumPathSum = Math.max(currentSum, maximumPathSum);

		return Math.max(leftSum , rightSum) + current.value;
	}

	public static void main(String[] args) {

		/*
		 * 1 2 3 4,8 6,7 4,9 3
		 * 
		 * 
		 * 8,2,1,3,6,4,6 = 30 - max sum
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		root.right.left.left = new TreeNode(4);
		root.right.left.right = new TreeNode(9);

		root.right.left.left.right = new TreeNode(6);

		System.out.println(sum(root));

	}
}
