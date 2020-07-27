package training.cadenas;

public class LongestPalindromicSubsequence {
	
	public static int longest(String s) {
		if(s==null) return 0;
		char[] chr = s.toCharArray();
		int n = chr.length;
		
		int [][] dp = new int[n][n];
		
		for(int i=0;i<n;i++) dp[i][i] = 1;
		
		for(int cl=2;cl<=n;cl++) {
			for (int i=0;i<n-cl+1;i++) {
				int j = i+cl-1;
				if(chr[i]==chr[j] && cl==2)
					dp[i][j]=2;
				else if(chr[i]==chr[j])
					dp[i][j]=dp[i+1][j-1] +2;
				else
					dp[i][j]= Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		
		return dp[0][n-1];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "GEEKSFORGEEKS";
		System.out.println(longest(s));
	}

}
