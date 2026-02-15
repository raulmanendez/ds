package start.binarySearch;

public class NextLetter {

	static char find(char letters[], char target) {

		int start = 0, end = letters.length - 1;

		if (target < letters[start] || target > letters[end])
			return letters[0];

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (target < letters[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}

		return letters[start % letters.length];
	}

	public static void main(String[] args) {

		System.out.println(find(new char[] { 'a','c','f','h' }, 'f'));
		System.out.println(find(new char[] { 'a','c','f','h' }, 'b'));
		System.out.println(find(new char[] { 'a','c','f','h' }, 'm'));
		System.out.println(find(new char[] { 'a','c','f','h' }, 'h'));
	}
}
