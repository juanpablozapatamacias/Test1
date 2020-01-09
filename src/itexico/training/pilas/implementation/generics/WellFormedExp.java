package itexico.training.pilas.implementation.generics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WellFormedExp {

	private static final Map<Character,Character> matchingParenMap = new HashMap<>();
	private static final Set<Character> openingParenSet = new HashSet<>();
	
	static {
		matchingParenMap.put(')', '(');
		matchingParenMap.put('}', '{');
		matchingParenMap.put(']', '[');
		openingParenSet.addAll(matchingParenMap.values());
	}
	
	public static boolean hasMatching(String input) {
		Stack<Character> parenStack = new Stack<>();
		char c;
		Character lastParen;
		
		try {
			
			for (int i=0;i<input.length();i++) {
				c = input.charAt(i);
				
				if(openingParenSet.contains(c)) parenStack.push(c);
				
				if(matchingParenMap.containsKey(c)) {
					lastParen = parenStack.pop();
					
					if(lastParen != matchingParenMap.get(c)) return false;
				}
			}
			
			return parenStack.isEmpty();
		}
		catch(StackOverflowException soe) {
			System.err.println("Stack Overflow");
		}
		catch(StackUnderFlowException sue) {
			System.err.println("Stack Underflow");
		}
		
		return false;
	}
	
	public static void main(String[] arg) {
		String exp1 = "[ABC] {CDE}(123)";
		System.out.println(hasMatching(exp1) ? "Match" : "Mismatch");
	} 
}
