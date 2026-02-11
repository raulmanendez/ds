package start.dfs;

import java.util.ArrayList;
import java.util.List;

import start.bfs.TreeNode;

public class SumOfPathNumbers {

	static int sum(TreeNode root) {
		List<String> numbers = new ArrayList<>();
		
		sumRecursive(root, root.value+"", numbers);
		
		System.out.println(numbers);
		return numbers.stream().map(Integer::parseInt).reduce(Integer::sum).get();
	}
	
	static String sumRecursive(TreeNode root, String number, List<String> numbers) {
		if(root==null) return "";
		
		if(root.left==null && root.right==null) {//found leaf node
			numbers.add(new String(number));
		} else {
			if(root.left!=null)
				number+=sumRecursive(root.left, number+root.left.value, numbers);
			
			if(root.right!=null)
				number+=sumRecursive(root.right, number+root.right.value, numbers);
		}

		number = "";
		
		return number;
	}
	
	static int pathSum(TreeNode root) {
		return pathSumRecursive(root, 0);
	}
	
	static int pathSumRecursive(TreeNode root, int pathSum) {
		if(root==null) return 0;
		
		pathSum = 10 * pathSum + root.value;
		
		if(root.left==null&& root.right==null)
			return pathSum;
		
		return pathSumRecursive(root.left, pathSum) +
				pathSumRecursive(root.right, pathSum);
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
		
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(9);

		System.out.println(sum(root));
	
		System.out.println(pathSum(root));
		
		
	}
}
