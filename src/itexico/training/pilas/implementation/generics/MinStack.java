package itexico.training.pilas.implementation.generics;

public class MinStack extends Stack<Integer> {

	Stack<Integer> stack = new Stack<Integer>();
	
	public void push(int val) 
			throws StackOverflowException, StackUnderFlowException {
		if(val <= min())stack.push(val);
		super.push(val);
	}
	
	public Integer pop() throws StackUnderFlowException {
		int val = super.pop();
		if(val == min()) stack.pop();
		return val;
	}
	
	public Integer min() throws StackUnderFlowException {
		if(stack.isEmpty()) return Integer.MAX_VALUE;
		else return stack.peek();
	}
	
	public static void main(String[] arg) throws StackOverflowException, StackUnderFlowException {
		MinStack m = new MinStack();
		m.push(1);
		m.push(4);
		m.push(2);
		System.out.println(m.min());
		m.pop();
		System.out.println(m.min());
		m.pop();
		System.out.println(m.min());
	}
}
