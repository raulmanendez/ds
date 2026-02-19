package start.xor;

public class SingleNumber {

	static int find(int input[]) {
		
		int num= input[0];
		for(int i=1;i< input.length;i++) {
			num = num^ input[i];
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(find(new int[] {1, 4, 2, 1, 3, 2, 3}));
		System.out.println(find(new int[] {7,9,7}));
	}
}
