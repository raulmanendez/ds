package start.array.recurse;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {

	public List<String> getPerm(String str) {
		if(str==null) return null;

		List<String> permutations=new ArrayList<>();
		if(str.length()==1) {
			permutations.add("");
			return permutations;
		}

		char removed=str.charAt(0);
		String remaining=str.substring(1);
		List<String> words=getPerm(remaining);

		for(String p:words) {

			for(int i=0;i<=p.length();i++) {

				String start=p.substring(0,i);
				String end=p.substring(i);
				String res=start+removed+end;

				permutations.add(res);

			}
		}

		return permutations;
	}

	public static void main(String[] args) {
		PermutationsWithoutDups test=new PermutationsWithoutDups();



		System.out.println(
				test.getPerm("abcd")
				);
	}
}
