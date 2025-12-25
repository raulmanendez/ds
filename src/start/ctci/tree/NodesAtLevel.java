package start.ctci.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class NodesAtLevel {

	public ArrayList<LinkedList<TreeNode>> getNodesAtLevel(TreeNode node) {
		ArrayList<LinkedList<TreeNode>> result=new ArrayList<>();

		return getNodesAtLevelRecurse(node, 0, result);
	}

	private ArrayList<LinkedList<TreeNode>> getNodesAtLevelRecurse(TreeNode node,int level,ArrayList<LinkedList<TreeNode>> result) {
		if(result.size() < level+1 ) {
			result.add(level, new LinkedList<>());
		}

		result.get(level).add(node);

		if(node.left!=null)
			getNodesAtLevelRecurse(node.left, level + 1, result);

		if(node.right!=null)
			getNodesAtLevelRecurse(node.right, level + 1, result);


		return result;
	}

	public ArrayList<LinkedList<TreeNode>> getNodesIteratively(TreeNode node) {
		ArrayList<LinkedList<TreeNode>> result=new ArrayList<>();

		LinkedList<TreeNode> ll=new LinkedList<>();
		ll.add(node);

		while(ll.size()>0) {
			result.add(ll);

			LinkedList<TreeNode> parents=ll;
			ll=new LinkedList<>();

			for(TreeNode parent:parents) {
				if(parent.left!=null)
					ll.add(parent.left);

				if(parent.right!=null)
					ll.add(parent.right);
			}
		}


		return result;
	}

	public static void main(String[] args) {
		NodesAtLevel test=new NodesAtLevel();

		BinaryTree tree=TreeFromSortedArray.formBt(new int [] {1,2,3,4,5,6,7,8,9,10} );

		System.out.println("Recursive::"+test.getNodesAtLevel(tree.getRoot()));

		System.out.println("Iteratively::"+test.getNodesIteratively(tree.getRoot()));

	}
}
