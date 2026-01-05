package start.array.recurse;

import java.util.ArrayList;
import java.util.List;

public class PowerSetV3 {

	void powerSet(int arr[]) {
		
		int n= arr.length;
		
		for(int mask=0; mask< (1<<n);mask++) {
			
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<n;i++) {
				
				if((mask & (1<<i))!=0) {
					list.add(arr[i]);
				}
			}
			System.out.println(list);
		}
	}
}
