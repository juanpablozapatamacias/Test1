package training.cadenas;

public class PalindromePermutation {
	
	public static boolean isPerm(String s) {
		if(s == null) return false;
		
		int countOdd = 0;
		int[] counts = new int[26];
		
		for(char c : s.toCharArray()){
			//validate a to z
			if(c >= 'a' && c <='z') {
				counts[c-'a']++;
				if(counts[c-'a'] % 2 == 1) countOdd++;
				else countOdd--;
			} 
		}
		return countOdd<2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerm("tact coa") ? "YES" : "NO");
	}

}
