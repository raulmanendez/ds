package start.ctci.strings;

import java.nio.charset.Charset;
import java.util.Map;

public class FindUnique {

	static boolean isUniqueChars(String str) {
		if(str.length() > 128) return false;

		boolean exists[]=new boolean[128];
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(exists[c]) {
				return false;
			}
			exists[c]=true;
		}

		return true;
	}


	public static void main(String[] args) {
		System.out.println(isUniqueChars("abhj"));
		System.out.println(isUniqueChars("ijklmnopqrstuvwx"));
		System.out.println(isUniqueChars("zxcvbnmlz"));
	}

	public static void bytes() {
		String c="ABC";

		for(byte b:c.getBytes(Charset.forName("ASCII")))
		System.out.println(b);
	}

	public static void availableCharacterSet() {
		Map<String, Charset> charsets = Charset.availableCharsets();
		charsets.entrySet().stream().forEach(s -> System.out.println(s.getKey() +" "+s.getValue()));
	}
}
