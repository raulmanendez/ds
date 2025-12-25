package start.array.recurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

	public List<List<Integer>> powerSet(List<Integer> set,int index) {
		System.out.println("calling for index:"+index);
		List<List<Integer>> result=null;

		if(set.size()==index) {
			System.out.println("will be called only once...for index:"+index);
			result=new ArrayList<>();
			result.add(new ArrayList<>());
			return result;
		} else {

			result=powerSet(set, index + 1);
			System.out.println("for index:"+index+" result="+result);
			int item=set.get(index);
			List<List<Integer>> moreSubsets=new ArrayList<>();

			for(List<Integer> subset:result ) {
				List<Integer> newSubset=new ArrayList<>();

				newSubset.addAll(subset);
				newSubset.add(item);

				moreSubsets.add(newSubset);
			}
			result.addAll(moreSubsets);
		}

		return result;
	}

	public static void main(String[] args) {
		PowerSet test=new PowerSet();

		System.out.println(
				test.powerSet(Arrays.asList(1,2,3),0)
		);


	}
}
