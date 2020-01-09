package itexico.training.cadenas;

public class LongestPalindrome {

	public static String longestPalindrome(String s) {
		if(s.isEmpty()) return "";
		
		int n = s.length();
		int longestSoFar = 0, startIndex = 0, endIndex = 0;
		boolean [][] palindromo = new boolean[n][n];
		
		for(int j=0;j<n;j++) {
			palindromo[j][j] = true;
			for (int i=0;i<j;i++) {
				if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || palindromo[i+1][j-1])) {
					palindromo[i][j] = true;
					if(j-i+1 > longestSoFar) {
						longestSoFar = j-i+1;
						startIndex = i;
						endIndex = j;
					}
				}
			}
		}
		return s.substring(startIndex, endIndex+1);
	}
	
	public static void main(String[] args) {
		String s = "cbbd";
		System.out.println(longestPalindrome(s));
	}
}
