package training.pilas.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
	
	public static boolean valid(String s) {
		Map<Character,Character> map = new HashMap<>();
		char c;
		char target;
		
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0;i<s.length();i++) {
			c = s.charAt(i);
			if(map.containsKey(c)) stack.push(c);
			else {
				if(stack.isEmpty()) return false;
				
				target = stack.pop();
				if(!map.containsKey(target) || map.get(target) != c) return false;
			}
		}
		if(!stack.isEmpty()) return false;
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(valid("(([{}]))()[]{}") ? "VALID" : "NO VALID");
	}

}
