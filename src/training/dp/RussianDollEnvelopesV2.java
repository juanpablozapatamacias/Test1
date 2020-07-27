package training.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopesV2 {
	
	public static int maximum(int[][] envelopes) {
		if(envelopes.length<1) return 0;
		if(envelopes.length<2) return 1;
		
		int[] dp = new int[envelopes.length];
		
		Arrays.fill(dp, 1);
		
		int max =1;
		
		Arrays.sort(envelopes, Comparator.comparing((int[] num) -> num[0]).thenComparing((int[] num) -> num[1]));
		
		for(int i=1;i<envelopes.length;i++) {
			for(int j=0;j<i;j++) {
				if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}

			if(dp[i] > max) max =dp[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maximum(A));
	}

}
