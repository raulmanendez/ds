package start.dfs;


import java.util.ArrayList;
import java.util.List;

import start.bfs.TreeNode;

public class CountAllPathSum {
	
	static int count(TreeNode root, int S) {
		List<Integer> currentPath = new ArrayList<>();
		return countRecrusive(root, currentPath, S);
	}
	
	static int countRecrusive(TreeNode current, List<Integer> currentPath, int S) {
		if(current==null) return 0;
		
		currentPath.add(current.value);
		int count =0, pathSum =0;
		var iterator = currentPath.listIterator(currentPath.size());
		while(iterator.hasPrevious()) {
			pathSum+=iterator.previous();
			
			System.out.println(currentPath+" "+pathSum+" "+S);
			if(pathSum==S) {
				count++;
			}
		}
		
		count+=countRecrusive(current.left, currentPath, S);
		count+=countRecrusive(current.right, currentPath, S);
		
		currentPath.remove(currentPath.size() - 1);
		
		
		return count;
	}
	
	
	public static void main(String[] args) {
		
		/*
		 * 1 2, 3 4,8 6,7
		 * 
		 * 2,8
		 * 6,4
		 * 6,3,1
		 * 7,3
		 * 
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

		
		System.out.println(count(root, 10));

		
		
	}
}
