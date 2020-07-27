package training.arrays;

public class RegularExpressionMatch {
	
	public static boolean isMatch(String s, String p) {
		int m = s.length(), n=p.length();
		boolean [][] dp = new boolean[m+1][n+1];
		
		dp[0][0]=true;
		
		// in case s=aa and p=a*
		for(int i=2;i<=n;i++) {
			if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-2];
		} 
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				char sc = s.charAt(i-1);
				char pc = p.charAt(j-1);
				
				if(sc == pc || pc == '.') {
					dp[i][j]=dp[i-1][j-1];
				}
				else if(pc=='*') {
					if(dp[i][j-2]) dp[i][j] = true;
					else if (sc==p.charAt(j-2) || p.charAt(j-2)=='.') dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "xaabyc";
		String p = "xa*b.c";
		
		System.out.println(isMatch(s,p));

	}

}
