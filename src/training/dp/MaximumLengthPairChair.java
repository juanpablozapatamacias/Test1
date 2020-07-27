package training.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthPairChair {
	
	public static int maximum (int[][] pairs) {
		if(pairs == null || pairs.length==0) return 0;
		
		int n = pairs.length;
		Arrays.sort(pairs, (p1,p2) -> Integer.compare(p1[0], p2[0]));
		
		int[] dp =  new int[n];
		Arrays.fill(dp,1);
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				int[] smaller = pairs[j], bigger=pairs[i];
				
				if(smaller[1] < bigger[0]) {
					dp[i] = Math.max(dp[i], dp[j] +1);
				}
			}
		}
		
		return dp[n-1];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,2},{2,3},{3,4}};
		
		System.out.println(maximum(A));
	}

}
