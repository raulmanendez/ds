package start.ctci.tree;

public class CommonAncestor {

	//method 3 - without link to parents
	public TreeNode getCommonAncestorV3(TreeNode root,TreeNode p,TreeNode q) {

		if(!covers(root,p) || !covers(root,q)) return null;

		if(root==null || root==p || root==q) return root;

		boolean pIsLeft=covers(root.left, p);
		boolean qIsLeft=covers(root.left, q);

		if(pIsLeft!=qIsLeft) return root;

		TreeNode nextRoot=pIsLeft ? root.left : root.right;

		return getCommonAncestorV3(nextRoot,p, q);
	}

	//method 2
	public TreeNode getCommonAncestorV2(TreeNode root,TreeNode p,TreeNode q) {
		if(!covers(root,p) || !covers(root,q)) return null;
		else if(covers(p,q)) return p;
		else if(covers(q,p)) return q;

		TreeNode parent=p.parent;
		TreeNode sibling=getSibling(parent);

		while(!covers(sibling,q)) {
			sibling=getSibling(parent);
			parent=parent.parent;
		}

		return parent;
	}

	private boolean covers(TreeNode p,TreeNode q) {
		if(p==null) return false;
		if(p==q) return true;
		return covers(p.left ,q) || covers(p.right ,q);
	}

	private TreeNode getSibling(TreeNode node) {
		if(node==null || node.parent==null) return null;
		TreeNode parent=node.parent;
		return parent.left == node ? parent.right : parent.left;
	}

	//method 1
	public TreeNode getCommonAncestorV1(TreeNode p,TreeNode q) {
		int pHeight=getHeight(p);
		int qHeight=getHeight(q);

		TreeNode deeper=p;TreeNode upper=q;
		if(pHeight > qHeight) {
			upper=p;
			deeper=q;
		} else {
			upper=q;
			deeper=p;
		}
		deeper=moveUp(deeper, Math.abs(qHeight - pHeight));

		while(upper.parent!=deeper.parent) {

			upper=upper.parent;
			deeper=deeper.parent;
		}

		return upper.parent;
	}

	private TreeNode moveUp(TreeNode node,int steps) {
		while(steps!=0) {
			node=node.parent;
			steps--;
		}

		return node;
	}

	private int getHeight(TreeNode node) {
		if(node==null) return -1;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}


	public static void main(String[] args) {
		CommonAncestor test=new CommonAncestor();

		BinaryTree tree=TreeFromSortedArray.formBt(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});

		TreeNode p=tree.find(1);
		TreeNode q=tree.find(12);

//		TreeNode p=tree.find(2);
//		TreeNode q=tree.find(13);

		System.out.println(test.getCommonAncestorV1(p, q));

	}
}
