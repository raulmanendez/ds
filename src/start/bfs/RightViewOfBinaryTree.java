package start.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

	static List<Integer> rightView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null) return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int levelSize = q.size();
			
			for(int i=0;i<levelSize;i++) {
				TreeNode current = q.poll();
				
				System.out.println(current.value + " "+i);
				if(i==levelSize - 1)
					result.add(current.value);
				
				if(current.left!=null)
					q.offer(current.left);
				if(current.right!=null)
					q.offer(current.right);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		/*
		 * 12 
		 * 7, 1
		 * 9, 10, 5
		 * 20, 17 
		 * 
		 * Right View - 12-1-5-17
		 */

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		System.out.println(
				rightView(root)
				);
	}
}
