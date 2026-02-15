package start.subsets;

public class CountUniqueTrees {

	static int countUniqueTrees(int n) {
		if (n <= 1)
			return 1;

		int count = 0;

		for (int i = 1; i <= n; i++) {

			int coutnOfLeftSubTrees = countUniqueTrees(i - 1);
			int coutnOfRightSubTrees = countUniqueTrees(n - i);

			count += coutnOfLeftSubTrees * coutnOfRightSubTrees;
		}

		return count;
	}

	public static void main(String[] args) {

		System.out.println(countUniqueTrees(3));

	}
}
