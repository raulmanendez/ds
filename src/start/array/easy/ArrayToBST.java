package start.array.easy;

public class ArrayToBST {

	public static TreeNode sortedArrayToBST(int[] nums) {

		return createNode(0, nums.length - 1, nums);

	}

	private static TreeNode createNode(int left, int right, int[] nums) {

		int mid = (left + right) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		
		
		
		if(left <= right) {
			//System.out.println(left+" and "+right+" and root:"+root.val);
			
			//System.out.println("Going left for root:"+root.val);
			TreeNode leftNode = createNode(left, mid - 1, nums);
			root.left = leftNode;
			//System.out.println("Left="+leftNode.val+" for "+root.val);
			

			//System.out.println("Going Right for root:"+root.val);
			TreeNode rightNode = createNode(mid + 1, right, nums);
			root.right = rightNode;
			//System.out.println("Right="+rightNode.val+" for "+root.val);
		} else {
			return null;
		}
		
		//System.out.println("Returning for"+root.val);
		
		return root;
	}

	public static void main(String[] args) {
		int arr[]=new int[] {-10,-3,0,5,9};
		
		TreeNode node=sortedArrayToBST(arr);
		
		node.print(node);
	}
}

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	void print(TreeNode node) {
		
		System.out.println("ROOT:"+node.val);
		
		if (node.left != null) {
			System.out.print("ROOT:"+node.val+" 's left is:"+node.left.val+"\t");

			print(node.left);
		}

		if (node.right != null) {
			System.out.print("ROOT:"+node.val+" 's right is:"+node.right.val+"\t");

			print(node.right);
		}

		

	}
}
