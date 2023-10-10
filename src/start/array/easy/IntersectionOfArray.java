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
		
		for(int i=0;i<nums1.length;i++) {
			set1.add(nums1[i]);
		}
		
		for(int i=0;i<nums2.length;i++) {
			if(set1.contains(nums2[i])) {
				set2.add(nums2[i]);
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
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		List<Integer> list=new ArrayList<>();
		
		for(int i=0;i<nums1.length;i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
		}
		
		for(int i=0;i<nums2.length;i++) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
				map.put(nums2[i], map.get(nums2[i])-1);
				list.add(nums2[i]);
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
