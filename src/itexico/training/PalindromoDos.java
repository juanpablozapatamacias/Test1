package itexico.training;

public class PalindromoDos {
	
	private static boolean isPalin(String s, int left, int right) {
		while(left<right) {
			if(s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			}
			else break;
		}
		return left >=right;
	}
	
	public static boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}
		
		if(left >= right) return true;
		
		if(isPalin(s,left+1,right) || isPalin(s,left,right-1)) return true;
		
		return false;
	}
	
	public static String longestPalindrome(String s) {
		if(s ==null || s.length()<=1) return s;
		
		int len = s.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];
		
		String longest = null;
		
		for(int l=0;l<s.length();l++) {
			for (int i=0;i<len-l;i++) {
				int j = i+l;
				if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1])) {
					dp[i][j] =true;
					
					if(j-i+1 > maxLen) {
						maxLen = j-i+1;
						longest = s.substring(i, j+1);
					}
				}
			}
		}
		
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validPalindrome("abcccca"));
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("abcccca"));
		System.out.println(longestPalindrome("ac"));
	}

}
