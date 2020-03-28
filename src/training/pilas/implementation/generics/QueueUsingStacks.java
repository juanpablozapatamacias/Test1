package training.pilas.implementation.generics;

class Queue<T>{
	Stack<T> leftStack = new Stack<T>();
	Stack<T> rightStack = new Stack<T>();
	
	void enqueue(T item) {
		try {
			leftStack.push(item);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	T dequeue() {
		try {
			transferIfNeeded();
			return rightStack.pop();
		} catch (StackUnderFlowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	T peek() {
		try {
			transferIfNeeded();
			return rightStack.peek();
		} catch (StackUnderFlowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	void transferIfNeeded() {
		// TODO Auto-generated method stub
		try {
			if(rightStack.isEmpty()) {
				while(!leftStack.isEmpty())
					rightStack.push(leftStack.pop());			 
			}
		}
		catch (StackOverflowException | StackUnderFlowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class QueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new Queue<>();
		
		System.out.println("Add elements to queue");
		queue.enqueue(6);
		queue.enqueue(5);
		queue.enqueue(9);
		
		System.out.println("Get the last element of queue: " + queue.peek());
		System.out.println("Remove elements from queue");
		queue.dequeue();
		
		System.out.println("Get the last element of queue: " + queue.peek());
		System.out.println("Remove elements from queue");
		queue.dequeue();
		
		System.out.println("Get the last element of queue: " + queue.peek());
		
	}

}
