package training.dp;

import java.util.Arrays;

public class BestTimeBuySellStock {
	
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length ==0) return 0;
		
		int n = prices.length;
		int[] dp = new int[n];
		
		Arrays.fill(dp, 0);
		
		int min = prices[0];
		for(int i=1;i<prices.length;i++) {
			//if(prices[i] < min) min = prices[i];
			min = Math.min(min, prices[i]);
			dp[i] = Math.max(dp[i-1], prices[i]-min);
		}
		
		return dp[prices.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7,1,5,3,6,4};
		System.out.println(maxProfit(A));
	}

}
