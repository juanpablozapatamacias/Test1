package itexico.training.pilas.implementation;

import java.util.Stack;

public class StackSequences {
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		
		for (int i=0;i<pushed.length;i++) {
			stack.push(pushed[i]);
			
			while (!stack.isEmpty() && j<pushed.length && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}
		
		return j==pushed.length;
	}
	
	public static void main(String[] argc) {
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,1,2};
		
		System.out.println(validateStackSequences(pushed,popped) ? true:false);
	}

}
