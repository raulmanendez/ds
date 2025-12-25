package start.ctci.strings;

import java.util.Arrays;

public class CheckPermutation {

	public static String sort(String s) {
		char content[]=s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	// O(s log s + d log d) with extra space to store 2 char arrays
	public static boolean approach1(String s,String d) {
		if(s.length()!=d.length()) return false;

		return sort(s).equals(sort(d));
	}

	//better O(s + d)
	public static boolean approach2(String s,String d) {

		int times[]=new int[128];//for ascii only

		for(int i=0;i<s.length();i++) {
			times[s.charAt(i)]++;
		}

		for(int i=0;i<d.length();i++) {
			times[d.charAt(i)]--;

			if(times[d.charAt(i)]<0) return false;
		}

		return true;
	}



	public static void main(String[] args) {
		System.out.println(approach1("hello", "olleh"));
		System.out.println(approach2("hello", "olleh"));

		System.out.println(approach1("home", "emoh"));
		System.out.println(approach2("home", "emoh"));

		System.out.println(approach1("illu", "lluu"));
		System.out.println(approach2("illu", "lluu"));

	}
}
