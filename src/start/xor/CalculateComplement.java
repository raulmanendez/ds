package start.xor;

public class CalculateComplement {

	static int complement(int input) {
		int num = input, bitCount = 0;

		while (num > 0) {
			num = num >> 1;
			bitCount++;
		}

		int allSetBits = (int) Math.pow(2, bitCount) - 1;

		return input ^ allSetBits;
	}

	public static void main(String[] args) {
		System.out.println(complement(8));// 7
		System.out.println(complement(10));// 5
	}
}
