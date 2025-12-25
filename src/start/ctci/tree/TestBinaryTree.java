package start.ctci.tree;

public class TestBinaryTree {


	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();

		tree.add(2);
		tree.add(3);
		tree.add(1);
		tree.add(8);
		tree.add(1);
		tree.add(5);
		tree.add(6);
		tree.add(4);
		tree.add(7);

		System.out.println(tree.inOrder());
	}
}
