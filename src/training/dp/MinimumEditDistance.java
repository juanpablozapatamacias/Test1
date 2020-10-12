package training.dp;

public class MinimumEditDistance {

	public static int minimum(String word1, String word2) {
	
		char[] c1 = word1.toCharArray();
		char[] c2 = word2.toCharArray();
		
		int[][] dp = new int[c1.length+1][c2.length+1];
		
		for(int i=0;i<dp[0].length;i++) dp[0][i] = i;
		for(int i=0;i<dp.length;i++)dp[i][0] = i;
		
		for(int i=1;i<=c1.length;i++) {
			for(int j=1;j<=c2.length;j++) {
				if(c1[i-1] == c2[j-1]) {
					dp[i][j]=dp[i-1][j-1];
				}
				else {
					//dp[i][j] = 1 + min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
					dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
				}
			}
		}
		return dp[c1.length][c2.length];
	}
	
	public static int min(int a, int b, int c) {
		int x = Math.min(a, b);
		return Math.min(x, c);
	}
	
	public static void main(String[] arg) {
		String s1="horse",s2="ros";
		System.out.println(minimum(s1,s2));
				
	}
}
