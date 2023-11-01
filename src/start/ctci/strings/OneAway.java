package start.ctci.strings;

public class OneAway {

	public static boolean oneAway(String s1, String s2) {

		if (Math.abs(s1.length() - s2.length()) > 1)
			return false;

		String shortString = s1.length() < s2.length() ? s1 : s2;
		String longString = s1.length() > s2.length() ? s1 : s2;

		int shortIndex = 0, longIndex = 0;
		boolean oneDifferent = false;

		while (shortIndex < shortString.length() && longIndex < longString.length()) {

			if (shortString.charAt(shortIndex) != longString.charAt(longIndex)) {

				if (oneDifferent)
					return false;
				oneDifferent = true;

				if (shortString.length() == longString.length()) {
					shortIndex++;
				}
			} else {
				shortIndex++;
			}

			longIndex++;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(oneAway("apple", "aple"));
		System.out.println(oneAway("aple", "apple"));

		System.out.println(oneAway("aple", "able"));
		System.out.println(oneAway("able", "aple"));

		System.out.println(oneAway("aa", "abv"));
	}
}
