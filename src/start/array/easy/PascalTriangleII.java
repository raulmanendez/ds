package start.array.easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangleII {
	static Map<Integer,BigInteger> map=new HashMap<>();
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result=new ArrayList<>();
		
		for(int i=0;i<=rowIndex;i++) {
			
			result.add(combination(rowIndex, i));
			
		}
		
		return result;
	}
	
	private static int combination(int n,int r) {
		
		return fact(n).divide((fact(r).multiply(fact(n-r)))).intValue();
	}
	
	private static BigInteger fact(int n) {
		if(n==0 || n==1) {
			return new BigInteger("1");
		}
		
		if(map.containsKey(n)) return map.get(n);
		
		BigInteger result=fact(n-1).multiply(new BigInteger(String.valueOf(n)));
		map.put(n, result);
		return result;
	}

	public static void main(String[] args) {

		System.out.println( getRow(13));
	}
}
