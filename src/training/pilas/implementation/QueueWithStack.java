package training.pilas.implementation;

import java.util.Stack;

public class QueueWithStack {
	
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();
	
	public static void enqueue(int x) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		s2.push(x);
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public static int dequeue() {
		if(s1.isEmpty()) {
			System.out.println("Q is empty");
			return 0;
		}
		
		int x = s1.peek();
		s1.pop();
		return x;
	}
	
	public static void main(String[] arg) {
		QueueWithStack qs = new QueueWithStack();
		qs.enqueue(4);
		qs.enqueue(1);
		qs.enqueue(5);
		
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
	}

}
