package start.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outer=new ArrayList<>(numRows);

		if(numRows<=0) return outer;

		outer.add(Arrays.asList(1));
		if(numRows==1) return outer;

		outer.add(Arrays.asList(1,1));
		if(numRows==2) return outer;


		for(int i=2;i<numRows;i++) {

			List<Integer> last=outer.get(i-1);

			List<Integer> latest=new ArrayList<>(i+1);
			latest.add(1);

			for(int j=0;j<last.size()-1;j++) {
				latest.add(last.get(j)+last.get(j+1));
			}

			latest.add(1);
			outer.add(latest);

		}

		return outer;
	}

	public static void main(String[] args) {

		System.out.println( generate(8));
	}

}
