package start.ctci.tree;

public class Subtree {

	
	public boolean subtreeV1(TreeNode t1,TreeNode t2) {
		if(t2==null) return true;
		
		StringBuilder t1Inorder=new StringBuilder();
		StringBuilder t2Inorder=new StringBuilder();
		
		subTreeInOrderString(t1, t1Inorder);
		subTreeInOrderString(t2, t2Inorder);
		
		System.out.println(t1Inorder);
		System.out.println(t2Inorder);
		
		return t1Inorder.indexOf(t1Inorder.toString())!=-1;
	}
	
	public void subTreeInOrderString(TreeNode node,StringBuilder builder) {
		if(node==null) {
			builder.append("X");
			return;
		}
		
		subTreeInOrderString(node.left, builder);
		builder.append(node.data+"");
		subTreeInOrderString(node.right, builder);
	}
	
	
	public boolean containsTree(TreeNode t1,TreeNode t2) {
		if(t2==null) return true;
		return subTree(t1, t2);
	}
	
	public boolean subTree(TreeNode t1,TreeNode t2) {
		if(t1==null) 
			return false;
		else if(t1.data==t2.data && matchTree(t1,t2))
			return true;
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	public boolean matchTree(TreeNode t1,TreeNode t2) {
		if(t1==null && t2==null) 
			return true;
		else if(t1==null || t2==null) 
			return false;
		else if(t1.data!=t2.data)
			return false;
		
		return matchTree(t1.left, t2.left) || matchTree(t1.right, t2.left);
	}
	
	public static void main(String[] args) {
		Subtree test=new Subtree();
		
		BinaryTree tree=TreeFromSortedArray.formBt(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
				
		System.out.println("subtree exists approach 1::"+
				test.subtreeV1(tree.find(8), tree.find(10))
		);
		
		System.out.println("subtree exists approach 2::"+
				test.containsTree(tree.find(8), tree.find(10))
		);
	}
}
