package start.array.easy;

import java.util.StringJoiner;

public class MyArrayUtil {

	public static void printArray(int arr[]) {

		StringJoiner joiner = new StringJoiner(",", "[", "]");

		for (int x : arr)
			joiner.add(String.valueOf(x));

		System.out.println(joiner.toString());
	}
}
