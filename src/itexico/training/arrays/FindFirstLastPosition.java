package itexico.training.arrays;

import java.util.Arrays;

public class FindFirstLastPosition {
	
	public static int[] searchRange(int[] nums, int target) {
		int[] res = {-1,-1};
		if(nums == null || nums.length==0) return res;
		
		merge(nums);
		
		int first = find(nums,target, true);
		if(first == -1) return res;
		
		int last = find(nums,target,false);
		
		res[0] = first;
		res[1] = last;
		return res;
	}
	
	private static int find(int[] nums, int target, boolean first) {
		// TODO Auto-generated method stub
		
		int left = 0;
		int right = nums.length-1;
		int res = -1;
		
		while(left <=right) {
			int mid = (left + right) >> 1;
			if(nums[mid] == target) {
				res = mid;
				if(first) right = mid -1;
				else left = mid+1;
			}
			else if (nums[mid] < target) {
				left = mid+1;
			}
			else right = mid -1;
		}
		
		return res;
	}

	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n > 1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {10,5,7,7,8,8};
		int[] res = searchRange(A,8);
		
		System.out.println(Arrays.toString(res));
	}

}
