package training.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IntersectionTwoArraysII {

	public static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) {
			return intersection(nums2,nums1);
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int[] result;
		int i = 0;
		
		for(int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
		
		List<Integer> list = new ArrayList<>();
		
		for(int num : nums2) {
			int count = map.getOrDefault(num, 0);
			if(count > 0) {
				list.add(num);
				map.put(num,count-1);
			}
		}
		
		result = new int[list.size()];
		for(int num : list) 
			result[i++] = num;
		
		return result;
	}
	
	public static int[] intersect(int[] nums1,int[] nums2) {
		List<Integer> list = new ArrayList<>();
		int i=0,j=0,k=0;
		int[] res;
		
		merge(nums1);
		merge(nums2);
		
		while(i < nums1.length && j < nums2.length) {
			if(nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}
			else if(nums1[i] < nums2[j]) i++;
			else j++;
		}
		
		res = new int[list.size()];
		for(int num : list) res[k++] = num;
		
		return res;
	}
	
	
	private static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for (int i=0;i<mid;i++) l[i] = arr[i];
			for (int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];
		}
	}
	
	
	public static void main(String[] ar) {
		int[] A = {1,2,2,1};
		int[] B = {2,2};
		
		System.out.println(Arrays.toString(intersection(A,B)));
		System.out.println(Arrays.toString(intersect(A,B)));
	}
}
