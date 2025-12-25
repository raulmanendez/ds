package start.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfArray {

	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set1=new HashSet<>();
		Set<Integer> set2=new HashSet<>();

		for (int element : nums1) {
			set1.add(element);
		}

		for (int element : nums2) {
			if(set1.contains(element)) {
				set2.add(element);
			}

		}

		int i=0;
		int result[]=new int[set2.size()];
		for(int value:set2) {
			result[i++]=value;
		}


		return result;

	}

public static int[] intersectionII(int[] nums1, int[] nums2) {

		Map<Integer,Integer> map=new HashMap<>();
		List<Integer> list=new ArrayList<>();

		for (int element : nums1) {
			map.put(element, map.getOrDefault(element, 0)+1);
		}

		for (int element : nums2) {
			if(map.containsKey(element) && map.get(element)>0) {
				map.put(element, map.get(element)-1);
				list.add(element);
			}

		}

		int i=0;
		int result[]=new int[list.size()];
		for(int value:list) {
			result[i++]=value;
		}


		return result;

	}

	public static void main(String[] args) {
		int arr1[] = { 4,9,9,5 };
		int arr2[] = { 9,4,9,8,4 };


		//int result[]=intersection(arr1, arr2);

		int resultII[]=intersectionII(arr1, arr2);


		//MyArrayUtil.printArray(result);
		MyArrayUtil.printArray(resultII);
	}
}
