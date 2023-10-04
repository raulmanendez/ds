package start.array.easy;

public class PalindromeNumber {

	public static boolean isPalindrome(int x) {

		if(x < 0) return false;
		
		int next = x, quotient = 0, reversed = 0;;
		while (next != 0) {
			quotient = next % 10;

			next = next / 10;

			reversed = reversed * 10 + quotient;

//			System.out.println(next+" and "+quotient+" reversed"+reversed);
		}

		return x == reversed;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
}
