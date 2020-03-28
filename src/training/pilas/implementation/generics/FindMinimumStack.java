package training.pilas.implementation.generics;

public class FindMinimumStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int data) 
			throws StackOverflowException, StackUnderFlowException {
		int min = data;
		if(!minStack.isEmpty()) {
			if(min > minStack.peek())
				min = minStack.peek();
		}
		stack.push(data);
		minStack.push(min);
	}
	
	public int pop() 
			throws StackUnderFlowException{
		minStack.pop();
		return stack.pop();
	}
	
	public int getMinimum() 
			throws StackUnderFlowException{
		return minStack.peek();
	}
	
	public static void main(String[] args) 
			throws StackOverflowException, StackUnderFlowException {
		FindMinimumStack find = new FindMinimumStack();
		find.push(3);
		find.push(5);
		find.push(1);
		find.push(2);
		System.out.println(find.getMinimum());
	}
}
