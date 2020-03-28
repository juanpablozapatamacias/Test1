package training.pilas.implementation;

import java.util.EmptyStackException;

public class Pila {

	private int[] arr;
	private int size;
	private int index = 0;
	
	public Pila(int size) {
		this.size = size;
		this.arr = new int[size];
	}
	
	public boolean isFull() {
		return index == size ? true:false;
	}
	
	public boolean isEmpty() {
		return index == 0? true:false;
	}
	
	public void push(int element) {
		if(!this.isFull()) {
			this.arr[index] = element;
			index++;
		}
		else throw new StackOverflowError("Stack is full");
	}
	
	public int pop(){
		if(!this.isEmpty()) return arr[--index];
		
		else throw new EmptyStackException();
	}
	
	public int peek() {
		if(!this.isEmpty()) return arr[index];
		else throw new EmptyStackException();
	}
	
	public int size() {
		return index;
	}
}
