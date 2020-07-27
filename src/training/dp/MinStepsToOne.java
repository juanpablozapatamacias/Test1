package training.dp;

public class MinStepsToOne {
	
	public static int steps(int n) {
		int[] dp = new int[n+1];
		
		dp[0]=0;
		dp[1]=0;
		
		for(int i=2;i<=n;i++) {
			dp[i] = 1 + dp[i-1];
			
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]);
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(steps(11));
	}

}
