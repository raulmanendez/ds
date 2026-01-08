package start.slidingwindow;

public class LongestSubArrayReplacingZeros {
	int longest(String s, int k) {

		int start = 0, onesCount = 0, maxLength = 0;
		for (int end = 0; end < s.length(); end++) {
			char endChar = s.charAt(end);

			if (endChar == '1') {
				onesCount++;
			}

			if (end - start + 1 - onesCount > k) {
				char startChar = s.charAt(start);
				if (startChar == '1') {
					onesCount--;
				}
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

	int longestv2(String s, int k) {

		int start = 0, maxLength = 0, zeros = 0;
		for (int end = 0; end < s.length(); end++) {
			if (s.charAt(end) == '0') {
				zeros++;
			}

			while (zeros > k) {
				if (s.charAt(start) == '0') {
					zeros--;
				}
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {

		System.out.println(new LongestSubArrayReplacingZeros().longest("10001010011", 2));

		System.out.println(new LongestSubArrayReplacingZeros().longestv2("10001010011", 2));

	}
}
