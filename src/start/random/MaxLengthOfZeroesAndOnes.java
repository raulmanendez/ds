package start.random;

import java.util.HashMap;

public class MaxLengthOfZeroesAndOnes {

	static int findMaxLength(int arr[]) {

		var map = new HashMap<Integer, Integer>();
		map.put(0, -1);//says prefix sum is 0 at index -1 [before array starts]

		int prefix = 0, maxLength = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				prefix -= 1;
			} else {
				prefix += 1;
			}

			if (map.containsKey(prefix)) {
				int len = i - map.get(prefix);
				maxLength = Math.max(maxLength, len);
			} else {
				map.put(prefix, i);
			}

		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(findMaxLength(new int[] { 1, 1, 1, 0, 0, 1, 0 }));
	}
}
