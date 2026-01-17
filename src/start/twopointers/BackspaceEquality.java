package start.twopointers;

public class BackspaceEquality {

	// aaa##b aa#b
	static boolean compare(String s1, String s2) {
		int startOne = s1.length() - 1;
		int startTwo = s2.length() - 1;

		while (startOne >= 0 || startTwo >= 0) {
			int c1 = getNextIndex(s1, startOne);
			int c2 = getNextIndex(s2, startTwo);

			System.out.println(c1 + " " + c2);
			if (c1 < 0 && c2 < 0) {
				return true;
			}

			if (c1 < 0 || c2 < 0) {
				return false;
			}

			if (s1.charAt(c1) != s2.charAt(c2)) {
				return false;
			}

			startOne = c1 - 1;
			startTwo = c2 - 1;
		}
		return true;
	}

	static int getNextIndex(String s, int start) {

		int bsCount = 0;
		while (start >= 0) {

			if (s.charAt(start) == '#') {
				bsCount++;
			} else if (bsCount > 0) {
				bsCount--;
			} else {
				break;
			}
			start--;
		}

		return start;
	}

	public static void main(String[] args) {
		System.out.println(BackspaceEquality.compare("xy#z", "xzz#"));
	}
}
