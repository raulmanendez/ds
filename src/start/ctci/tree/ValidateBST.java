package start.ctci.tree;

class WrapperData {
	public Integer data;
}

public class ValidateBST {

	public static boolean isValidUsingWrapper(TreeNode node,WrapperData wrapper) {
		if(node==null) return true;

		if(!isValidUsingWrapper(node.left, wrapper) || (wrapper.data!=null && wrapper.data > node.data)) return false;

		wrapper.data=node.data;

		if(!isValidUsingWrapper(node.right, wrapper)) return false;

		return true;
	}


	public static boolean isValid(TreeNode node) {
		if(node==null) return true;

		if(node.left!=null && node.right!=null) {
			return isValid(node.left) && isValid(node.right);
		}

		if(node.left!=null) {
			return node.data > node.left.data;
		} else if(node.right!=null){
			return node.data < node.right.data;
		}

		return true;
	}

	public static void main(String[] args) {
		BinaryTree tree1=TreeFromSortedArray.formBt(new int[] {1,2,3,4,5,6,7});

		boolean isValid=isValid(tree1.getRoot());

		System.out.println("Tree 1 valid::"+isValid);

		isValid=isValidUsingWrapper(tree1.getRoot(), new WrapperData());
		System.out.println("Tree 1 valid using wrapper::"+isValid);

		System.out.println("Attaching invalid node..");
		TreeNode targetNode=tree1.find(7);
		TreeNode invalidNode=new TreeNode();
		invalidNode.data=9;
		targetNode.left=invalidNode;

		isValid=isValid(tree1.getRoot());

		System.out.println("Tree 1 valid after attaching invalid node::"+isValid);

		isValid=isValidUsingWrapper(tree1.getRoot(), new WrapperData());
		System.out.println("Tree 1 valid after attaching invalid node using wrapper::"+isValid);

	}
}
