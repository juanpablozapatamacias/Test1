package itexico.training.cadenas;

public class ShortestPalindrome {
	
	public static String shortestPalindrome(String s) {
		int n = s.length();
		String rev = new StringBuilder(s).reverse().toString();
		int j = 0;
		
		for(int i=0;i<s.length();i++) {
			System.out.println(s.substring(0, n-i));
			System.out.println(rev.substring(i));
			System.out.println(rev.substring(0,i));
			System.out.println(rev.substring(0,i) + s);
			if(s.substring(0, n-i).equals(rev.substring(i))) return rev.substring(0, i) + s;
		}
		return "";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aacecaaa";
		
		System.out.println(shortestPalindrome(s));
	}

}
