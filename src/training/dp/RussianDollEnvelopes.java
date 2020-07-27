package training.dp;

import java.util.Arrays;

public class RussianDollEnvelopes {

	public static int maximum(int[][] envelopes) {
		if(envelopes == null || envelopes.length==0) return 0;
		
		int n = envelopes.length;
		int[] dp = new int[n];
		int len =0;
		
		Arrays.sort(envelopes,(a,b) -> a[0] == b[0] ? b[1] -a[1] : a[0] - b[0]);
		
		for(int[] e : envelopes) {
			int index = binarySearch(dp,0,len,e[1]);
			//int index = Arrays.binarySearch(dp, 0, len, e[1]);
			
			if(index < 0) {
				index=-(index+1);
			}
			
			dp[index] = e[1];
			if(index == len) len++;
			
		}
		
		return len;
	}
	
	public static int binarySearch(int[] arr, int low, int high, int target) {
		int l = low;
		int h = high -1;
		
		
		while(l <= h) {
			int mid = (low + high) >>> 1;
			int midVal = arr[mid];
			
			if (midVal < target) l = mid +1;
			else if (midVal > target) h = mid -1;
			else return mid;
		}
		
		return -(l+1);
	}
	
	public static void main(String[] arg) {
		int[][] A = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maximum(A));
	}
}
