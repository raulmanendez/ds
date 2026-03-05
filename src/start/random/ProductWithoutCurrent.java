package start.random;

import start.Util;

public class ProductWithoutCurrent {

	static int[] product(int arr[]) {

		int n = arr.length;
		int result[] = new int[n];

		for (int i = 0; i < n; i++)
			result[i] = 1;

		int prefix = 1, suffix = 1;
		for (int i = 0; i < n; i++) {
			// left Product
			result[i] *= prefix;
			prefix *= arr[i];

			// right Product
			int last = arr.length - 1 - i;
			result[last] *= suffix;
			suffix *= arr[last];

		}

		return result;
	}

	public static void main(String[] args) {
		Util.print(product(new int[] { 1, 2, 3, 4 }));// 24-12-8-6
	}
}
