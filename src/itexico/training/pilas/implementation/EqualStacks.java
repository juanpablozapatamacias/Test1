package itexico.training.pilas.implementation;

import java.util.Stack;

public class EqualStacks {
	
	public static int calculateMinHeight(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	
	public static int equalHeights(int[] a, int[] b, int[] c) {
		/*Stack of the cylinders*/
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		
		/* Height of the stacks*/
		
		int sum1=0,sum2=0,sum3=0;
		
		/* Stack with smallest height*/
		int minStack;
		
		/* Initialize the stacks and their heights (O(A+B+C)) applying the for loop in reverse*/
		for(int i=a.length-1;i>=0;i--) {
			s1.push(a[i]);
			sum1 += a[i];
		}
		
		for(int i=b.length-1;i>=0;i--) {
			s2.push(b[i]);
			sum2 += b[i];
		}
		
		for(int i=c.length-1;i>=0;i--) {
			s3.push(c[i]);
			sum3 += c[i];
		}
		
		/*Initialize the stack with min height*/
		minStack = calculateMinHeight(sum1,sum2,sum3);
		
		// Heights are not all equal enter the loop (O(N*(A+B+C))
		while(sum1!=sum2 || sum1!=sum3) {
			// Remove cylinders from stack 1 until height is <= the smallest
			while(sum1 > minStack) sum1 -= s1.pop();
			
			// Recalculate the stack
			minStack = calculateMinHeight(sum1,sum2,sum3);
			
			// Remove cylinders from stack 1 until height is <= the smallest
			while(sum2 > minStack) sum2 -= s2.pop();
			
			// Recalculate the stack
			minStack = calculateMinHeight(sum1,sum2,sum3);
			
			// Remove cylinders from stack 1 until height is <= the smallest
			while(sum3 > minStack) sum3 -= s3.pop();
			
			// Recalculate the stack
			minStack = calculateMinHeight(sum1,sum2,sum3);
		}
			
		return minStack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,2,1,1,1};
		int[] b = {4,3,2};
		int[] c = {1,1,4,1};
		
		System.out.println(equalHeights(a,b,c));
	}

}
