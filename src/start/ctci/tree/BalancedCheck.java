package start.ctci.tree;

public class BalancedCheck {
	public static int getHeightV1(TreeNode node) {
		if(node== null) return -1;
		
		int leftHeight=getHeight(node.left);
		if(leftHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight=getHeight(node.right);
		if(rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		if((Math.abs(leftHeight) - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight,rightHeight) + 1;
		}
	}
	
	public static boolean isBalancedV1(TreeNode node) {
		return getHeightV1(node) != Integer.MIN_VALUE;
	}
	
	public static int getHeight(TreeNode node) {
		if(node== null) return -1;
		return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
	}
	
	public static boolean isBalanced(TreeNode node) {
		if(node==null) return true;
		
		int leftHeight=getHeight(node.left);
		int rightHeight=getHeight(node.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		} else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt=TreeFromSortedArray.formBt(new int[] { 1,2,3,4,5,6,7 });
		
		/*
		//for unbalanced tree
		TreeNode searched=bt.find(7);
		TreeNode eight=new TreeNode();
		eight.data=8;
		searched.right=eight;
		
		TreeNode nine=new TreeNode();
		nine.data=9;
		eight.right=nine;
		*/
		System.out.println(bt.inOrder());
		
		boolean balanced=isBalanced(bt.getRoot());
		
		System.out.println("Is balanced::"+balanced);
		
	}
}
