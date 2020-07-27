package training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIIV1 {
	
	public static int[] twoSum(int[] nums, int target) {
		//if(nums == null || nums.length==0) return;
		
		merge(nums);
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i])+1,i+1};
			map.put(nums[i],i);
		}
		
		throw new IllegalArgumentException("No solution");
	}
	
	public static void merge(int[] arr) {
		int n=arr.length;
		int mid = n >>1;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i]=arr[i];
			for(int j=mid;j<n;j++) r[j-mid]=arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i]<=r[j]) arr[k++] = l[i++];
				else arr[k++]=r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length)arr[k++] = r[j++];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(a,target)));
	} 

}
