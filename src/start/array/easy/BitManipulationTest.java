package start.array.easy;

public class BitManipulationTest {
	public static void main(String[] args) {
		int num=5;
		
		System.out.println("Binary equivalent of "+num+" is "+Integer.toBinaryString(num));
		
		int andNum=num & (1 << 2);
		
		System.out.println(Integer.toBinaryString(andNum));
		
		int orNum=num | (1 << 1);
		
		System.out.println(Integer.toBinaryString(orNum));
		
		int negNum=num | ~(1 << 0);
		
		System.out.println(Integer.toBinaryString(negNum));
	}
}
