package start.array.recurse;

import java.util.ArrayList;
import java.util.List;

public class PrintParenthesisV2 {

	List<String> print(int x) {
		return print(x, new ArrayList<>());
	}
	
	List<String> print(int x, List<String> result) {
		if(x==1) {
			var list = new ArrayList<String>();
			list.add("()");
			return list;
		}
		
		List<String> old = print(x -1);
		
		int size= old.size();
		for(String paren:old) {
			
			//System.out.println("paren=>"+paren);
			
			for(int i=0;i<paren.length();i++) {
				
				String start=paren.substring(0, i);
				String end=paren.substring(i, paren.length());
				
				//System.out.println("start=>"+start);
				//System.out.println("end=>"+end);
				
				String res = start + "()" + end;
				
				//System.out.println(res);
				result.add(res);
			}
		}
		
		
		return result;
		
	}
	
	public static void main(String[] args) {
		System.out.println(
		new PrintParenthesisV2().print(3)
				);
	}
}
