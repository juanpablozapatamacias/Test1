package training.dp;

import java.util.Arrays;

public class PalindromicSubstring {
	
	public static int count(String s) {
		if(s == null || s.length() == 0) return 0;
		
		int len = s.length();
		boolean [][] dp = new boolean [len][len];
		int count = 0;
		
		//Arrays.fill(dp, false);
		Arrays.stream(dp).forEach(a -> Arrays.fill(a, false));
		
		for(int i=len-1; i>=0; i--) {
			for(int j=i;j<len;j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(j-i < 2) dp[i][j] = true;
					else dp[i][j] = dp[i+1][j-1];
				}
				
				if(dp[i][j]) count++;
			}
		}
		
		return count;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println(count(s));
	}

}
