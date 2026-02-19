package start.xor;

public class TwoSingleNumber {

	static int[] find(int input[]) {
		
		int n1xn2= 0;
		for(int num: input) {
			n1xn2 ^= num;
		}
		
		int rightMostSetBit = 1;
		while((n1xn2 & rightMostSetBit )==0) {
			rightMostSetBit = rightMostSetBit << 1;
			
			System.out.println(rightMostSetBit);
		}
		
		int num1=0,num2=0;	
		for(int num:input) {
			if((num & rightMostSetBit) == 0)
				num1^=num;
			else
				num2^=num;
		}
		
		System.out.println(num1 + " "+ num2);
		return new int[] {num1, num2};
	}
	
	public static void main(String[] args) {
		find(new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5});//4,6
	}
	
}
