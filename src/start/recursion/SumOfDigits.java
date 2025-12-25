package start.recursion;

public class SumOfDigits {

	public static int sumOfDigits(int number) {

		if(number/10==0)
			return number;
		else {
			int carry=number % 10;
			int quotient=number/10;
			return carry + sumOfDigits(quotient);
		}
	}

	public static void main(String[] args) {
		System.out.println("Sum of numbers of 321 is::"+sumOfDigits(321));
		System.out.println("Sum of numbers of 765 is::"+sumOfDigits(765));
	}
}
