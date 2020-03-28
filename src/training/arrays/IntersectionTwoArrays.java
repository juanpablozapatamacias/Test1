package training.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArrays {
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> intersection = new HashSet<Integer>();
		int[] result;
		int index = 0;
		
		for (int i : nums1) {
			set.add(i);	
		}
		
		for(int i : nums2) {
			if(set.contains(i)) {
				intersection.add(i);
			}
		}
		
		result = new int [intersection.size()];
		index = 0;
		for(int i : intersection) {
			result[index++] = i;
		}
		
		return result;
	}
	
	public static void main(String[] ar) {
		int[] A = {1,2,2,1};
		int[] B = {2,2};
		
		System.out.println(Arrays.toString(intersection(A,B)));
	}

}
