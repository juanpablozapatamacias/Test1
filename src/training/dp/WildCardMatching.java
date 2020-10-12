package training.dp;

public class WildCardMatching {

	public static boolean isMatch(String s, String p) {
		
		char[] str = s.toCharArray();
		char[] pat = p.toCharArray();
		
		int writeIndex = 0;
		boolean isFirst = true;
		
		for(int i=0;i<pat.length;i++) {
			if(pat[i] == '*') {
				if(isFirst) {
					pat[writeIndex++]=pat[i];
					isFirst=false;
				}
			}
			else {
				pat[writeIndex++]=pat[i];
				isFirst=true;
			}	
		}
		
		boolean[][] dp = new boolean[str.length+1][writeIndex+1];
		
		if(writeIndex > 0 && pat[0]=='*')
			dp[0][1] = true;
		
		dp[0][0] = true;
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(pat[j-1] == '?' || str[i-1] == pat[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}
				else if(pat[j-1] == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		
		return dp[str.length][writeIndex];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aapi";
		String p = "*p?";
		
		System.out.println(isMatch(s,p));
	}

}
