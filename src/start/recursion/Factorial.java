package start.recursion;

public class Factorial {

	public static int factorial(int num) {
		if(num == 2)
			return 2;
		else return num * factorial(num - 1);
	}
	
	public static void main(String[] args) {
		System.out.println("Factorial of 5 is::"+factorial(5));
		System.out.println("Factorial of 4 is::"+factorial(4));
		System.out.println("Factorial of 3 is::"+factorial(3));
	}
}
