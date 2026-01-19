package start.hareandtortoise;

public class HappyNumber {

	static boolean isHappy(int num) {

		int slow = num;
		int fast = num;

		while (true) {
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));

			System.out.println(slow + " " + fast);
			if (slow == fast)
				break;
		}

		return slow == 1;
	}

	static int squareSum(int num) {
		int sum = 0;
		while (num > 0) {
			int lastDigit = num % 10;
			sum += lastDigit * lastDigit;
			num = num / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(HappyNumber.isHappy(12));

		int count = 20;
		int number = 12;
		while (count > 0) {
			number= HappyNumber.squareSum(number);
			count--;
			System.out.println(number);
		}

	}
}
