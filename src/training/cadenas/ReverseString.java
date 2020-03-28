package training.cadenas;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {

	public static void reverse(char[] s) {
		int start = 0;
		int end = s.length - 1;
		char temp;
		
		while(start <= end) {
			temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			
			start++;
			end--;
		}
	}
	
	public static void main(String[] ar) {
		String s="hello";
		char[] c = s.toCharArray();
		reverse(c);
		
		System.out.println(Arrays.toString(c));
	}
}
