package training.arrays;

import java.util.Arrays;

public class CoinChange {
	
	public static int change(int[] coins, int amount) {
		int n = coins.length;
		int max = amount + 1;
		int[] dp = new int[amount+1];
		
		Arrays.fill(dp, max);
		dp[0] = 0;
		
		for (int i=1;i<=amount;i++) {
			for (int j=0; j<n;j++) {
				if(coins[j] <= i) {
					dp[i]=Math.min(dp[i], 1 + dp[i-coins[j]]);
				}
				else {
					break;
				}
			}
		}
		
		return dp[amount] > amount ? -1:dp[amount];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {1,2,5};
		int amt = 11;
		
		System.out.println(change(c,amt));
	}

}
