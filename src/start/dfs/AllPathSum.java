package start.dfs;

import java.util.ArrayList;
import java.util.List;

import start.bfs.TreeNode;

public class AllPathSum {

	static List<List<Integer>> hasSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		hasSumRecursive(root, sum, currentPath, result);
		return result;
	}
	
	static void hasSumRecursive(TreeNode root, int sum,List<Integer> currentPath, List<List<Integer>> result) {
		if(root==null) return;
		
		currentPath.add(root.value);
		
		System.out.println(currentPath);
		
		if (sum == root.value && root.left == null && root.right == null){
			 result.add(new ArrayList<>(currentPath));
		} else {
			hasSumRecursive(root.left, sum - root.value, currentPath, result);
			hasSumRecursive(root.right, sum - root.value, currentPath, result);
		}

		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {

		/*
		 * 1 2, 3 4,8 6,7
		 * 
		 * 11 - 1,2,8 | 1,3,7 
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(hasSum(root, 11));
	}
}
