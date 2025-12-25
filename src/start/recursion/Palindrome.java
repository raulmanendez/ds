package start.recursion;

public class Palindrome {

	private static boolean palindrome(String str,int start,int end) {

		if(start>end) return true;

		if(str.charAt(start)!=str.charAt(end))
			return false;
		else
			return palindrome(str, start+1, end-1);
	}

	public static boolean palindrome(String str) {
		return palindrome(str, 0, str.length()-1);
	}

	public static void main(String[] args) {
		System.out.println("Palindrome::"+palindrome("tennet"));
		System.out.println("Palindrome::"+palindrome("teehnhneet"));
	}
}
