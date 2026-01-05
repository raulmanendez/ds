package start.array.recurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetV2 {
	
	List<List<Integer>> powerSet(int arr[]) {
	
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		for(int a:arr) {
			System.out.println("for a ="+a);
			int size = result.size();//much needed
			for(int i=0;i<size;i++) {
				List<Integer> subSet = new ArrayList<Integer>(result.get(i));
				
				subSet.add(a);
				result.add(subSet);
				System.out.println("for a ="+a+ " and i="+i+" subset="+subSet);
			}
		}
		
		return result;
	}
	
public static void main(String[] args) {
	System.out.println(
	new PowerSetV2().powerSet(new int[] {1,2,3})
			);
	
}
}
