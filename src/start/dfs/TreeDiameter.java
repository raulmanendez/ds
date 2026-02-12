package start.dfs;

import start.bfs.TreeNode;

public class TreeDiameter {

	static int treeDiameter =0;
	
	static int diameter(TreeNode root) {
		findHeight(root);
		return treeDiameter;
	}
	
	static int findHeight(TreeNode current) {
		if(current==null) return 0;
		
		int leftHeight = findHeight(current.left);
		int rightHeight = findHeight(current.right);
		
		int diameter = leftHeight + rightHeight + 1;
		
		treeDiameter = Math.max(treeDiameter, diameter);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {

		/*
		 * 1 
		 * 2 3
		 * 4,8 6,7
		 * 4,9
		 * 41
		 * 
		 * 
		 * 8,2,1,3,6,4,41 - longest diameter
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
		
		root.right.left.left.right = new TreeNode(41);

		System.out.println(diameter(root));

	}
}
