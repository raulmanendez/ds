package start.random;

import start.bfs.TreeNode;

public class BinaryTreeSymmetry {

	static boolean isSymmetric(TreeNode root) {
		if(root==null) return false;
		return isSymmetricc(root.left, root.right);
	}
	
	static boolean isSymmetricc(TreeNode left,TreeNode right) {
		if(left==null && right==null) return true; 
		if(left==null || right==null) return false;
		
		if(left.value != right.value) return false;
		
		if(!isSymmetricc(left.left, right.right)) return false;
		
		return isSymmetricc(left.right, right.left);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		
		System.out.println(isSymmetric(root));
	}
}
