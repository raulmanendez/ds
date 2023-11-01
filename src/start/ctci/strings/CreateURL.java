package start.ctci.strings;

public class CreateURL {

	public static String URLify(String s,int length) {
		
		int emptyIndex=s.length()-1;
		char content[]=s.toCharArray();
		
		for(int i=length-1 ;i >= 0 ; i--) {
			
			if(s.charAt(i)==' ') {
				content[emptyIndex--]='0';
				content[emptyIndex--]='2';
				content[emptyIndex--]='%';
			} else {
				content[emptyIndex--]=s.charAt(i);
			}
		}
		
		return new String(content);
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(URLify("Mr John Smith    ",13));
	}
}
