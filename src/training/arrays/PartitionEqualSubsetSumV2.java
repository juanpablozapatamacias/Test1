package training.arrays;

public class PartitionEqualSubsetSumV2 {
	
	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		int total=0;
		
		for(int i : nums) total += i;
		
		if(total%2 !=0) return false;
		
		total /= 2;
		
		// Building DP array [Num elements array][total sum elements array divided into 2]
		boolean[][] dp = new boolean[n+1][total+1]; 
		
		//Prefill values with index dp[0][1] as with sum zero we can find subarray with blank array
		for(int i=0;i<n+1;i++) 
			dp[0][i] = true;
		
		// Prefill values with index dp[0][ array[element] == sum] by upgrading first row in dp matris
		//for(int j=1;j<=total;j++)
			//dp[0][j] = (nums[0] == total ? true:false);

		
		for(int i=1; i<n+1; i++) {
			
			if(nums[i-1] > total) continue;
			
			for(int j=1; j<total+1; j++) {
				if(nums[i-1] > j) dp[i][j] = dp[i-1][j];
				else if(nums[i-1] <= j) dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]; 
			}
		}
		
		return dp[n][total];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,11,5};
		System.out.println(canPartition(a));
	}

}
