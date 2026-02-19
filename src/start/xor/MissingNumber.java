package start.xor;

public class MissingNumber {

	public static int findMissing(int input[]) {
		int len = input.length;

		int x1 = 1;
		for (int i = 2; i <= len + 1; i++) {
			x1 = x1 ^ i;
		}

		int x2 = input[0];
		for (int i = 1; i < len; i++) {
			x2 = x2 ^ input[i];
		}

		return x1 ^ x2;
	}

	public static void main(String[] args) {
		System.out.println(findMissing(new int[] { 1, 5, 2, 6, 4 }));// 3
	}
}
