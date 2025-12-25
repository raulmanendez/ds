package start.ctci.tree;

import java.util.StringJoiner;

public class BinaryTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void add(int data) {
		root=this.addRec(root,data);
	}

	public TreeNode addRec(TreeNode root,int data) {

		if(root==null) {
			root=new TreeNode();
			root.data=data;
			return root;
		}

		if(data < root.data) {
			root.left=addRec(root.left,data);
			root.left.parent=root;
		} else if(data > root.data) {
			root.right=addRec(root.right,data);
			root.right.parent=root;
		}

		return root;
	}

	public TreeNode find(int data) {
		return findRecurse(data, root);
	}

	private TreeNode findRecurse(int data,TreeNode node) {
		if(node==null) return null;

		if(node.data==data)
			return node;

		if(node.left!=null && node.left.data==data) return node.left;
		if(node.right!=null && node.right.data==data) return node.right;

		TreeNode left=findRecurse(data, node.left);
		TreeNode right=findRecurse(data, node.right);

		TreeNode result=left!=null && left.data==data ? left : right;

		return result;
	}

	public String inOrder() {
		StringJoiner joiner=new StringJoiner(",");
		inOrderRecurse(root, joiner);
		return joiner.toString();
	}

	private void inOrderRecurse(TreeNode node,StringJoiner joiner) {
		if(node==null) return;
		inOrderRecurse(node.left,joiner);
		joiner.add(node.data+"");
		inOrderRecurse(node.right,joiner);
	}

}
