package start.array.easy;

import java.util.StringJoiner;

public class MyArrayUtil {

	public static void printArray(int arr[]) {

		StringJoiner joiner = new StringJoiner(",", "[", "]");

		for (int x : arr)
			joiner.add(String.valueOf(x));

		System.out.println(joiner.toString());
	}

	public static void print(int[][] x) {
		for (int[] i : x) {
			for (int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}
}
