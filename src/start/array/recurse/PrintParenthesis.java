package start.array.recurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintParenthesis {

	public Set<String> printParenthesis(int x) {
		return printParenthesis(x, new ArrayList<>()).
				stream().filter(s -> s.length()==x*2)
				.collect(Collectors.toSet());
	}

	public ArrayList<String> printParenthesis(int x,ArrayList<String> result) {
		if(x==1) {
			ArrayList<String> base=new ArrayList<>();
			base.add("()");
			return base;
		}

		ArrayList<String> previousResult=(ArrayList<String>) printParenthesis(x-1, result).clone();

		for(String n:previousResult) {
			for(int i=0;i<n.length();i++) {
				result.add(appendAt(i, n));
			}
		}

		return result;
	}

	private String appendAt(int index,String existing) {
		String before=existing.substring(0, index);
		String after=existing.substring(index);
		return before+"()"+after;
	}

	//approach 2
	public List<String> getRes(int x) {
		char[] str=new char[x*2];
		List<String> result=new ArrayList<>();
		getre(str, result, x, x,0);

		return result;
	}

	public void getre(char arr[],List<String> result,int l,int r,int index) {
		System.out.println(String.valueOf(arr)+" left:"+l+" right:"+r);
		if(l< 0 || l > r) return;

		if(l==0 && r==0) {
			result.add(String.valueOf(arr));
		} else {
			arr[index]='(';
			getre(arr, result, l - 1, r, index+1);

			arr[index]=')';
			getre(arr, result, l, r - 1, index+1);
		}
	}


	public static void main(String[] args) {
		PrintParenthesis test=new PrintParenthesis();

		int x=3;

		//System.out.println("_______My way::"+test.printParenthesis(x));

		System.out.println("Optimized way::"+test.getRes(x));
	}
}
