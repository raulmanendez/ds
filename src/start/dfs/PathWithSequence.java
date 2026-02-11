package start.dfs;


import start.bfs.TreeNode;

public class PathWithSequence {
	
	static boolean pathWithSequence(TreeNode root, int[] sequence) {
		return pathWithSequenceRecursive(root, sequence, 0);
	}
	//this one works in one direction only
	static boolean pathWithSequenceRecursive(TreeNode root, int[] sequence, int currentIndex) {
		if(root==null) return true;
		
		System.out.println(root.value+" "+ sequence[currentIndex]);
		
		if(root.value!=sequence[currentIndex]) {
			return false;
		}
		
		
		if(root.left==null && root.right==null)
			return true;
		
		if(root.left!=null && root.left.value==sequence[currentIndex+1]) {
			return pathWithSequenceRecursive(root.left,sequence, currentIndex+1);
		} else if(root.right!=null && root.right.value==sequence[currentIndex+1]) {
			return pathWithSequenceRecursive(root.right,sequence, currentIndex+1);
		} else {
			return false;
		}
	}
	
	static boolean findPathV2(TreeNode root, int[] sequence) {
		if(root==null)
			return sequence.length==0;
		
		return findPathRecursiveV2(root, sequence, 0);
	}
	
	static boolean findPathRecursiveV2(TreeNode current, int[] sequence, int currentIndex) {
		if(current==null) return false;
		
		System.out.println(current.value+" "+ sequence[currentIndex]);
		
		if(currentIndex >= sequence.length || sequence[currentIndex]!= current.value)
			return false;
		
		if(currentIndex==sequence.length-1 && current.left==null && current.right==null)
			return true;
		
		
		return findPathRecursiveV2(current.left, sequence, currentIndex + 1) || findPathRecursiveV2(current.right, sequence, currentIndex + 1);
	}
	
	
	public static void main(String[] args) {
		
		/*
		 * 1 2, 3 4,8 6,7
		 * 
		 */

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(9);

		int sequence[] = new int[]{1,3,6,9};
		
		System.out.println(pathWithSequence(root, sequence));
		System.out.println(findPathV2(root, sequence));
		
		
	}
}
