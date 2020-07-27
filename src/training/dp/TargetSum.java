package training.dp;

public class TargetSum {
	
	public static int find(int[] nums, int S) {
		int sum = 0;
		for(int num : nums) sum +=num;
		
		if(S > sum || -S < -sum || (S+sum) %2 == 1) return 0;
		
		int[] dp = new int[(S + sum) /2 + 1];
		dp[0] =1;
		
		for (int num : nums) {
			for(int i = dp.length-1;i>=num;i--) {
				dp[i] += dp[i-num];
			}
		}
		
		return dp[dp.length-1];
	}

	public static void main(String[] args) {
		int[] A = {0,0,0,0,0,0,0,0,1};
		int S = 1;
		System.out.println(find(A,S));
	}

}
