package start.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import start.bfs.TreeNode;

class KV {
	TreeNode node;
	int col;

	KV(TreeNode node, int col) {
		this.node = node;
		this.col = col;
	}
}

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class BinaryTreeColumn {

	static List<ArrayList<Integer>> columns(TreeNode root) {
		if (root == null)
			return List.of();

		var q = new LinkedList<KV>();
		q.add(new KV(root, 0));

		var map = new HashMap<Integer, ArrayList<Integer>>();

		int leftMost = 0, rightMost = 0;
		while (!q.isEmpty()) {
			KV polled = q.poll();
			if (polled.node != null) {

				map.put(polled.col, map.getOrDefault(polled.col, new ArrayList<>()));
				map.get(polled.col).add(polled.node.value);

				leftMost = Math.min(leftMost, polled.col);
				rightMost = Math.max(rightMost, polled.col);

				q.add(new KV(polled.node.left, polled.col - 1));
				q.add(new KV(polled.node.right, polled.col + 1));
			}
		}

		var result = new ArrayList<ArrayList<Integer>>();
		for (int i = leftMost; i <= rightMost; i++) {
			result.add(map.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(5);
//		
//		root.left = new TreeNode(9);
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(1);
//
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(7);

		TreeNode root = new TreeNode(9);

		root.left = new TreeNode(3);

		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(columns(root));
	}
}
