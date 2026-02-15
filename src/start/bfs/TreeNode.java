package start.bfs;

import java.util.StringJoiner;

public class TreeNode {

	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public void inorder() {
		StringJoiner joiner = new StringJoiner(",","{","}");
		inorder(this, joiner);
		System.out.println(joiner);
	}
	
	void inorder(TreeNode root, StringJoiner joiner) {
		if(root==null) return;
		
		joiner.add(root.value+"");
		
		if(root.left!=null) {
			inorder(root.left, joiner);
		}
		
		if(root.right!=null) {
			inorder(root.right, joiner);
		}
	}
}
