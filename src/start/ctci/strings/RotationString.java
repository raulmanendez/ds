package start.ctci.strings;

public class RotationString {

	public static boolean isRotation(String s1, String s2) {
		int length = s1.length();

		if (length == s2.length() && length > 0) {
			String s1s1 = s1 + s1;

			return isSubstring(s1s1, s2);
		}

		return false;

	}

	public static boolean isSubstring(String s1, String s2) {
		// dummy method
		return false;
	}

	public static void main(String[] args) {

	}
}
