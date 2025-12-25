package start.recursion;

public class Power {

	public static int power(int base,int power) {
		if(power==1) return base;
		else return base *power(base,power - 1);
	}

	public static void main(String[] args) {
		System.out.println("Power of 2 base 4 is::"+power(2, 5));
	}
}
