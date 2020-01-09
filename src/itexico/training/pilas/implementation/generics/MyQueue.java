package itexico.training.pilas.implementation.generics;

public class MyQueue {
	Stack<Integer> value = new Stack<Integer>();
	Stack<Integer> temp = new Stack<Integer>();
	
	public void push(int x) 
			throws StackOverflowException, StackUnderFlowException {
		if(value.isEmpty()) value.push(x);
		else {
			while(!value.isEmpty()) 
				temp.push(value.pop());
			
			value.push(x);
			
			while(!temp.isEmpty()) 
				value.push(temp.pop());
		}
	}
	
	// removes the element in front of queue
	public void pop()
			throws StackOverflowException, StackUnderFlowException {
		value.pop();
	}
	
	// get the front element
	public int peek() 
			throws StackOverflowException, StackUnderFlowException{
		return value.peek();
	}
	
	// validate if queue is empty
	public boolean isEmpty() {
		return value.isEmpty();
	}
	
	public static void main(String[] ar) throws StackOverflowException, StackUnderFlowException {
		MyQueue queue = new MyQueue();
		
		queue.push(4);
		queue.push(5);
		queue.push(1);

		queue.pop();
		
		System.out.println(queue.toString());
	}

}
