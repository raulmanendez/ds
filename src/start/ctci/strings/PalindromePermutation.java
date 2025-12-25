package start.ctci.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	//approaach 1
	private static boolean isPermutationOfPalindrome1(String s) {

		int arr[]=new int[26];
		int oddCount=0;
		for(int i=0;i<s.length();i++) {
			int index=getIndex(s.charAt(i));
			arr[index]++;

			if(arr[index] % 2==0) {
				oddCount--;
			} else {
				oddCount++;
			}
		}

		return oddCount <=1 ;
	}

	private static int getIndex(char c) {
		int z=Character.getNumericValue('z');
		int a=Character.getNumericValue('a');
		int value=Character.getNumericValue(c);

		if(value >=a && value <=z )
			return z - value;

		return -1;
	}

	//approaach 1

	private static boolean isPermutationOfPalindrome2(String s) {

		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i < s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}

		int odds=0;
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {

			if(entry.getValue() % 2!=0) {
				odds++;
			}

			if(odds > 1) return false;
		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println(isPermutationOfPalindrome1("rejkrekj"));

//		System.out.println(isPermutationOfPalindrome2("rejkrekj"));
//		System.out.println(isPermutationOfPalindrome2("rejkrek"));
//		System.out.println(isPermutationOfPalindrome2("rejkek"));
	}
}
