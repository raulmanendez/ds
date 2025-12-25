package start.ctci.strings;

public class CompressString {

	public static String compress(String str) {

		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<str.length();i++) {
			buffer.append(str.charAt(i));

			int count=1;
			while(i+1<str.length() && str.charAt(i)==str.charAt(i+1)) {
				count++;
				i++;
			}
			buffer.append(count);
		}

		return buffer.length() < str.length() ? buffer.toString() : str;
	}

	public static void main(String[] args) {
		System.out.println(compress("aaaabbcvvvvhjjjx"));
	}

}
