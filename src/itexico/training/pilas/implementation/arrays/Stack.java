package itexico.training.pilas.implementation.arrays;

public class Stack {

	private int n = 0;
	private int[] items;
	private int cima;
	
	public Stack() {
		this(100);
	}

	public Stack(int size) {
		// TODO Auto-generated constructor stub
		cima = -1;		
		items = new int[size];
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public boolean isFull() {
		return n == items.length;
	}
	
	public void push(int dato) {
		items[n++] = dato;
	}
	
	public int pop() {
		return items[--n];
	}
	
	public int peek() {
		return items[items.length];
	}
}
