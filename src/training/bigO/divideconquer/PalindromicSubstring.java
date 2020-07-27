package training.bigO.divideconquer;

public class PalindromicSubstring {
	
	static int count=1;
	
	public static int count(String s) {
		if(s.length()==0) return 0;
		
		for(int i=0;i<s.length()-1;i++) {
			checkPalindrome(s,i,i);
			checkPalindrome(s,i,i+1);
		}
		
		return count;
	}

	private static void checkPalindrome(String s, int i, int j) {
		// TODO Auto-generated method stub
		while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
			count++;
			i--;
			j++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println(count(s));
	}

}
