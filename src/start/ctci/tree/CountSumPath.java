package start.ctci.tree;

import java.util.HashMap;

public class CountSumPath {

	public int countSumPath(TreeNode root,int targetSum) {
		if(root==null) return 0;
		int pathsfromRoot=countSumPathNode(root,targetSum,0);

		int pathsLeft=countSumPath(root.left, targetSum);
		int pathsRight=countSumPath(root.right, targetSum);


		return pathsfromRoot + pathsLeft + pathsRight;
	}

	public int countSumPathNode(TreeNode node,int targetSum,int currentSum) {
		if(node==null) return 0;

		currentSum += node.data;

		int totalPaths=0;
		if(currentSum == targetSum) {
			totalPaths++;
		}

		totalPaths+=countSumPathNode(node.left, targetSum, currentSum);
		totalPaths+=countSumPathNode(node.right, targetSum, currentSum);

		return totalPaths;
	}

	public int countSumPathV1(TreeNode root,int targetSum) {
		return countPathWithSum(root, targetSum, targetSum, new HashMap<>());
	}

	public int countPathWithSum(TreeNode node,int targetSum,int runningSum,HashMap<Integer, Integer> pathCount) {
		if(node==null) return 0;

		int totalPaths=0;

		incrementHashTable(pathCount, totalPaths, 1);
		totalPaths+= countPathWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths+= countPathWithSum(node.right, targetSum, runningSum, pathCount);
		incrementHashTable(pathCount, totalPaths, -1);

		return totalPaths;
	}

	private void incrementHashTable(HashMap<Integer, Integer> map,int key,int sum) {
		int newValue=map.getOrDefault(key, 0) + sum;

		if(newValue==0) {
			map.remove(key);
		} else {
			map.put(key, newValue);
		}
	}

	public static void main(String[] args) {

	}

}
