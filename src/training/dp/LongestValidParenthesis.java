package training.dp;

public class LongestValidParenthesis {

	public static int longest(String s) {
		int[] dp = new int [s.length() + 1];
		int res = 0;
		
		for(int i=1; i< s.length(); i++) {
			int j = i - dp[i] - 1;
			if(s.charAt(i)==')' && j>=0 && s.charAt(j)=='(')
				dp[i+1]=dp[i]+dp[j]+2;
			
			res = Math.max(res, dp[i+1]);
		}
		return res;
	}
	
	public static void main(String[] arg) {
		String s="(()";
		System.out.println(longest(s));
	}
	
}
