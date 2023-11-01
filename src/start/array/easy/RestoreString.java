package start.array.easy;

public class RestoreString {

	public static String restoreString(String s, int[] indices) {

		StringBuffer result=new StringBuffer(s);
		for (int i=0;i<indices.length;i++) {
			result.setCharAt(indices[i], s.charAt(i));
		}

		return result.toString();
	}

	public static void main(String[] args) {

		System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
	}
}
