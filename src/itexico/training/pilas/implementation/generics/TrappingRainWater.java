package itexico.training.pilas.implementation.generics;

public class TrappingRainWater {
	
	/**
	 * 
	 * Method that allows to represent how much water is able to trap after raining
	 * @param A
	 * @return int that counts the units of water trapped
	 * @throws StackUnderFlowException 
	 * @throws StackOverflowException 
	 * 
	 * **/
	
	public int trap(int[] A)  {
		int cur = 0;
		int vol = 0;
		int b; // used to pop the stack value
		Stack<Integer> stack = new Stack<>();
		
		try {
			// skip zeros
			while(cur < A.length && A[cur] == 0) ++cur;
			
			// check each element
			while (cur < A.length) {
				while(!stack.isEmpty() && A[cur] >= A[stack.peek()]) {
					b = stack.pop();
					
					if(stack.isEmpty()) break;
					
					vol +=((cur - stack.peek() -1)*(Math.min(A[cur], A[stack.peek()]) - A[b]));
				}
				stack.push(cur);
				++cur;
			}
			
			return vol;
		}
		catch(StackOverflowException | StackUnderFlowException e) {
			System.err.println("Exception");
		}
		return -1;
	}
	
	public static void main(String[] arg) {
		TrappingRainWater t = new TrappingRainWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(t.trap(A));
	}

}
