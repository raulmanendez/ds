package start.recursion;

import java.util.StringJoiner;

public class Fibonacci {

	public static int fibonacci(int num) {
		if(num == 1)
			return 0;
		else if(num == 2 || num==3)
			return 1;
		else return fibonacci(num - 1) + fibonacci(num - 2);
	}
	
	public static void main(String[] args) {
		System.out.println("Fibonacci of 10 numbers is::");
		
		StringJoiner joiner=new StringJoiner(",","[","]");
		for(int i=1;i<=10;i++) {
			joiner.add(fibonacci(i)+"");
		}
		
		System.out.println(joiner);
	}
}
