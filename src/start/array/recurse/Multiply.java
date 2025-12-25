package start.array.recurse;

public class Multiply {

	public int multiply(int x,int y) {
		int smaller= x < y ? x :y;
		int larger= x > y ? y : x;
		return x + mul(larger, smaller);
	}

	public int mul(int x,int y) {
		if(y==0) return 0;

		return x + multiply(x, y-1);
	}


	public static void main(String[] args) {
		Multiply test=new Multiply();

		System.out.println(
				test.mul(3, 6)
		);
	}
}
