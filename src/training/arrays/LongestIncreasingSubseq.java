package training.arrays;

import java.util.Arrays;

public class LongestIncreasingSubseq {
	
	public static int lengthLIS(int[] nums) {
		if(nums == null || nums.length==0) return 0;
		int[] dp  = new int[nums.length];
		int len = 0;
		
		for(int num : nums) {
			int index = Arrays.binarySearch(dp, 0, len, num);
			//int index = binarySearch(dp,0,len,num);
			if(index < 0) 
				index = -(index+1);
			
			dp[index]=num;
			
			if(index == len) 
				++len;
		}
		return len;
	}
	
	public static int lenghtLISBS(int[] nums) {
		if(nums == null || nums.length==0) return 0;
		int[] dp  = new int[nums.length];
		int len = 0;
		
		dp[0] = nums[0];
		
		for (int i=1;i<nums.length;i++) {
			int pos = binarySearch(nums,0,len,nums[i]) + 1;
			nums[pos] = nums[i];
			
			if(pos>len) len = pos;
		}
		
		return len + 1;
		
	}
	
	private static int binarySearch(int[] arr, int low, int high, int k) {
		while(low <= high) {
			int mid = low + (high-low) /2;
			
			if(arr[mid] >= k) high = mid-1;
			else low = mid +1;
		}
		
		return(low - 1) >= 0 ? (low-1) : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {10,9,2,5,3,7,101,18};
		System.out.println(lengthLIS(A));
		System.out.println(lenghtLISBS(A));
	}

}
