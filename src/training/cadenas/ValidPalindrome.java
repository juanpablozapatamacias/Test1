package training.cadenas;

import java.util.Stack;

public class ValidPalindrome {

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		char[] str = s.toCharArray();
		
		if(str == null || str.length == 0) return true;
		
		String reverse = "";
		String temp=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		for(int i=0;i<temp.length();i++) 
			st.push(temp.charAt(i));

		while(!st.isEmpty()) reverse += st.pop();
		
		return temp.equals(reverse);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("A man, a plan, a canal: Panama") ? "VALID":"NO VALID");
	}

}
