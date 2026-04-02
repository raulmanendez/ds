package start.random;

import java.util.ArrayList;
import java.util.List;
import start.bfs.TreeNode;

public class SerializeNDeSerializeTree {

	static String serialize(TreeNode root) {
		if (root == null)
			return "";

		List<String> list = new ArrayList<>();
		serialize(root, list);
		StringBuilder sb = new StringBuilder();
		for (String ch : list) {
			sb.append(ch + ",");
		}

		return sb.toString();
	}

	// pre-order
	static void serialize(TreeNode root, List<String> result) {
		if (root == null) {
			result.add("#");
			return;
		}

		result.add(root.value + "");

		serialize(root.left, result);
		serialize(root.right, result);
	}

	// pre-order
	static int currentIndex = 0;
	static TreeNode deserialize(String[] result) {
		if (result.length <= currentIndex) {
			return null;
		}
	
		if("#".equals(result[currentIndex])) return null;
	
		System.out.println(result[currentIndex]);
		TreeNode root = new TreeNode(Integer.parseInt(result[currentIndex]));
		currentIndex++;
		root.left = deserialize(result);
		currentIndex++;
		root.right = deserialize(result);

		return root;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(9);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(11);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(6);
		root.right.right = new TreeNode(7);

		String serialized = serialize(root); 
		System.out.println("serialized => "+serialized);
		
		
		TreeNode deserialized = deserialize(serialized.split(","));
		deserialized.inorder();
		
	}
}
