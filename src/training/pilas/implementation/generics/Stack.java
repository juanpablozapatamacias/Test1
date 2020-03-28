package training.pilas.implementation.generics;

public class Stack<T>{
	
	public static int MAX_SIZE=40;
	private Element<T> top;
	private int size = 0;
	
	public void push(T data) throws StackOverflowException{
		if(size == MAX_SIZE) throw new StackOverflowException();
		
		Element ele = new Element(data, top);
		top = ele;
		size++;
	}
	
	public T pop() throws StackUnderFlowException{
		if (size == 0) throw new StackUnderFlowException();
		
		T data = top.getData();
		top = top.getNext();
		
		size--;
		
		return data;
	}
	
	public T peek() throws StackUnderFlowException{
		if (size == 0) throw new StackUnderFlowException();
		
		return top.getData();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public int getSize() {
		return size;
	}

}
