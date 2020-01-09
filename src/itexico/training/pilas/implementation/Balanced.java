package itexico.training.pilas.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Balanced {
		
	public static boolean balancedBrackets(String s) {
		Stack<Character> st = new Stack<Character>();
		char last;	
		for(char c : s.toCharArray()) {
			if(st.empty()) {
				st.push(c);
				continue;
			}
			
			last = st.peek();
			
			switch (c) {
				case ')':
					if(last!='(') return false;
					st.pop();
					break;
				case '}':
					if(last!='{') return false;
					st.pop();
					break;
				case ']':
					if(last!='[') return false;
					st.pop();
					break;
				default:
					if (c=='(' || c=='[' || c=='{') {
						st.push(c);
					}
					if (c==')' || c==']' || c=='}') {
						return false;
					}
					break;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balancedBrackets("{[()]}") ? "YES" : "NO");
		System.out.println(balancedBrackets("{[(])}") ? "YES" : "NO");
		System.out.println(balancedBrackets("{{[[(())]]}}") ? "YES" : "NO");
	}

}
