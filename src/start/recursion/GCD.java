package start.recursion;

public class GCD {

	public static int gcd(int a,int b) {
		if(a%b==0) return b;
		else return gcd(b,a%b);
	}

	public static void main(String[] args) {
		System.out.println("GCD of 35 and 15 is::"+gcd(15,35));
		System.out.println("GCD of 31 and 6 is::"+gcd(6,31));
	}
}
