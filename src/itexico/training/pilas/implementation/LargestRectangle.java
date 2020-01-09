package itexico.training.pilas.implementation;

import java.util.Stack;

public class LargestRectangle {
	
	public static int largestRectangleArea(int[] A) {
		Stack<Integer> s = new Stack<Integer>();
		int max = 0;
		int i = 0;
		int p,h,w;
		
		if(A == null || A.length ==0) return 0;
		
		while(i< A.length) {
			//push index to stack when the current height is larger than previous one
			if(s.isEmpty() || A[i] > A[s.peek()]) {
				s.push(i);
				i++;
			}
			else {
			// calculate the max value when current height is less than previous one
				p = s.pop();
				h = A[p];
				w = s.isEmpty() ? i : i - s.peek() - 1;
				max = Math.max(h * w, max);
			}
		}
		
		while(!s.isEmpty()) {
			p = s.pop();
			h = A[p];
			w = s.isEmpty() ? i : i - s.peek() - 1;
			max = Math.max(h * w, max);
		}
		return max;
		
	}
	
	public static void main(String[] arg) {
		int A[] = {1,2,3,4,5};
		System.out.println(largestRectangleArea(A));
	}

}
