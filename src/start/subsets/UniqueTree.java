package start.subsets;

import java.util.ArrayList;
import java.util.List;

import start.bfs.TreeNode;

public class UniqueTree {

	static List<TreeNode> findUniqueTrees(int n) {
		if (n <= 0)
			return new ArrayList<>();
		return findUniqueTrees(1, n);
	}

	static List<TreeNode> findUniqueTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {

			List<TreeNode> leftSubTrees = findUniqueTrees(start, i - 1);
			List<TreeNode> rightSubTrees = findUniqueTrees(i + 1, end);

			for (TreeNode leftSubTree : leftSubTrees) {

				for (TreeNode rightSubTree : rightSubTrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftSubTree;
					root.right = rightSubTree;
					result.add(root);
				}

			}
		}

		return result;
	}

	public static void main(String[] args) {

		findUniqueTrees(3).forEach(it -> it.inorder());

	}
}
