package itexico.training.pilas.implementation.generics;

public class LargestRectangle {
	
	public int area(int[] height) throws StackUnderFlowException, StackOverflowException {
		if(height == null || height.length == 0) return 0;
		
		Stack<Integer> stack = new Stack<>();
		int max=0;
		int i=0;
		int p,w,h;
		
		while(i < height.length) {
			//push index to stack when the current height is larger than previous one
			if(stack.isEmpty() || height[i] >= height[stack.peek()]) {
				 stack.push(i);
				 i++;
			}
			else {
				// calculate max value when current height is less than previous one
				p = stack.pop();
				h = height[p];
				w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h*w, max);
			}
		}
		
		while(!stack.isEmpty()) {
			// calculate max value when current height is less than previous one
			p = stack.pop();
			h = height[p];
			w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h*w, max);
		}
		return max;
		
	}

	public static void main(String[] args) throws StackUnderFlowException, StackOverflowException {
		// TODO Auto-generated method stub
		int[] A= {2,1,5,6,2,3};
		LargestRectangle l = new LargestRectangle();
		System.out.println(l.area(A));
	}

}
