package training.dp;

import java.util.Arrays;

public class NumberLongestIncreasingSubseq {
	
	public static int maximum(int[] nums) {
		int n = nums.length;
		int max =0;
		
		int[] len = new int[n];
		int[] cnt = new int[n];
		
		Arrays.fill(len, 1);
		Arrays.fill(cnt, 1);
		
		for(int i=0;i<n;i++) {
			for(int j=i-1;j>=0;j--) {
				if(nums[j] < nums[i]) {
					if(len[j] + 1 > len[i]) {
						len[i] = len[j]+1;
						cnt[i] = cnt[j];
					}
					else if(len[j]+1 == len[i]) {
						cnt[i] += cnt[j]; 
					}
				}
			}
			
			max = Math.max(max, len[i]);
		}
		
		int res = 0;
		
		for(int i=0;i<n;i++) {
			if(len[i] ==  max) res += cnt[i];
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,4,7};
		System.out.println(maximum(A));
	}

}
