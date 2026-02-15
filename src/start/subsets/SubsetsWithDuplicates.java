package start.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {

	static List<List<Integer>> subsets(int input[]) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		
		Arrays.sort(input);
		int endIndex = 0;
		for(int i=0;i<input.length;i++) {
			int startIndex = 0;
			
			if(i>0 && input[i] == input[i-1]) {
				startIndex =  endIndex + 1;
			}
			
			endIndex = result.size() - 1;
			
			for(int j=startIndex;j<=endIndex;j++) {
				List<Integer> list = new ArrayList<>(result.get(j));
				list.add(input[i]);
				
				result.add(list);
			}				
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 3, 5, 3, 5 }));
	}
}
