package training.cadenas;

import java.util.Stack;

public class ReverseOnlyLetters {
	
	public static String reverse(String S) {
		if (S == null || S.length() == 0) return "";
		
		char[] c = S.toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<c.length;i++) {
			if(Character.isLetter(c[i])) stack.push(c[i]);
		}
		
		for(int i=0;i<c.length;i++) {
			if(Character.isLetter(c[i])) sb.append(stack.pop());
			else sb.append(c[i]);
		}
		
		return sb.toString();
		
	}

	public static String reverseOnlyLetters(String S) {
		char[] c = S.toCharArray();
		int i = 0;
		int j = S.length()-1;
		
		while(i < j) {
			while(i < j && !Character.isLetter(S.charAt(i))) {
				i++;
			}
			
			while(j > i && !Character.isLetter(S.charAt(j))) {
				j--;
			}
			
			char temp = c[i];
			c[i++] = c[j];
			c[j--] = temp;
		}
		
		return new String(c);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("Test1ng-Leet=code-Q!"));
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

}
