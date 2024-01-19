package start.ctci.tree;

public class Successer {

	
	public TreeNode getSuccesser(TreeNode node) {
		if(node==null) return null;
		
		if(node.right!=null) {
			return leftMostNode(node.right);
		} else {
			TreeNode current=node;
			TreeNode parent=current.parent;
			
			while(parent!=null && parent.left!=current) {
				System.out.println("current is::"+current);
				current=parent;
				parent=parent.parent;
			}
			
			return parent; 
		}
	}
	
	public TreeNode leftMostNode(TreeNode node) {
		if(node==null) return null;
		
		while(node.left!=null) {
			node=node.left;
		}
		return node;
	}
	
	public void testParent() {
		BinaryTree btree=TreeFromSortedArray.formBt(new int[] {1,2,3,4,5,6,7});
		
		TreeNode two=btree.find(2);
		
		TreeNode three=btree.find(3);
		TreeNode five=btree.find(5);
		
		System.out.println("2's parent:: 4 => "+two.parent);
		System.out.println("3's parent:: 2 => "+three.parent);
		System.out.println("5's parent:: 6 => "+five.parent);
	}
	
	public static void main(String[] args) {
		Successer test=new Successer();
		BinaryTree btree=TreeFromSortedArray.formBt(new int[] {1,2,3,4,5,6,7});
		
		System.out.println("3's should be 4 =>"+test.getSuccesser(btree.find(3)));
		System.out.println("4's should be 5 =>"+test.getSuccesser(btree.find(4)));
		System.out.println("7's should be null =>"+test.getSuccesser(btree.find(7)));
	}
}
