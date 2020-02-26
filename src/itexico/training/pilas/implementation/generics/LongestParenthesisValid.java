package itexico.training.pilas.implementation.generics;

public class LongestParenthesisValid {

	public static int longestValidParenthesis(String s) throws StackUnderFlowException, StackOverflowException {
		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek())=='(') {
				stack.pop();
			}
			else {
				if(!stack.isEmpty()) {
					res = Math.max(res, i-1-stack.peek());
				}
				else {
					res = Math.max(res, i);
				}
				stack.push(i);
			}
		}
		return res;
	}
	
	public static void main(String[] arg) throws StackUnderFlowException, StackOverflowException {
		String s = "()()((()())))))";
		System.out.println(longestValidParenthesis(s));
	}
}
