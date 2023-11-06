package start.ctci.strings;

public class RotateMatrix {

	public static boolean rotate(int[][] matrix) {

		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false;

		int n = matrix.length;

		for (int layer = 0; layer < n / 2; layer++) {

			
			
			int first = layer;
			int last = n - 1 - layer;

			System.out.println("layer and first::"+layer+" and last::"+last);
			
			for (int i = first; i < last; i++) {

				int offset = i - first;
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;

			}
		}

		return true;
	}

	public static void print(int[][] x) {
		for (int[] i : x) {
			for (int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

//		int x[][] = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 } };
		int x[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {13,14, 15, 16} };

		System.out.println("Before Rotating..");
		print(x);

		rotate(x);

		System.out.println("After Rotating again..");
		print(x);

	}
}
