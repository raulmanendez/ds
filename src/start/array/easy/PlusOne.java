package start.array.easy;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		
		int end=digits.length-1;
		int carry=1;
		while(end>=0) {
			
			int sum=digits[end]+carry;
			if(sum>=10) {
				digits[end]=sum-10;
				carry=1;
			} else {
				digits[end]=sum;
				carry=0;
			}
			end--;
		}
		
		if(carry!=0) {
			int newDigits[]=new int[digits.length+1];
			newDigits[0]=1;
			
			for(int i=0;i<digits.length;i++) {
				newDigits[i+1]=digits[i];
			}
			
			digits=newDigits;
		}
		
		return digits;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 9, 9 };
		int result[] = plusOne(arr);

		
		for(int x:result)		
			System.out.println(x);
	}
}
