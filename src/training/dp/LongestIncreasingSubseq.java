package training.dp;

import java.util.Arrays;

public class LongestIncreasingSubseq {
	
	public static int lenght(int[] nums) {
		if(nums==null || nums.length ==0) return 0;
		
		int[] dp = new int[nums.length];
		int len =0;
		
		for (int num : nums) {
			int index = Arrays.binarySearch(dp,0,len,num);
			if(index<0) index = -(index+1);
			
			dp[index]  =num;
			
			if(index==len) len++;
			
		}
		
		return len;
		
	}
	
	public static int binarySearch(int[] arr, int low, int high, int target) {
		while(low<=high) {
			int mid = low + (high-low) / 2;
		
			if (arr[mid] >= target) high = mid-1;
			else low=mid+1;
			
		}
		return (low-1) >=0 ? (low-1) : 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {10,9,2,5,3,7,101,18};
		System.out.println(lenght(A));
	}

}
