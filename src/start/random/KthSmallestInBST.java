package start.random;

import java.util.ArrayList;
import java.util.List;
import start.bfs.TreeNode;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestInBST {

	static int kth(TreeNode root, int k) {
		List<Integer> result = new ArrayList<>();
		kth(root, k, result);
		return result.get(k-1);
	}

	static void kth(TreeNode root, int k, List<Integer> list) {

		if (root == null)
			return;

		if (root.left != null)
			kth(root.left, k, list);

		list.add(root.value);

		if (root.right != null)
			kth(root.right, k, list);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);

		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		System.out.println(kth(root, 5));
	}
}
