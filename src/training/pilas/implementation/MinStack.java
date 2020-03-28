package training.pilas.implementation;

class Elem{
	public int value;
	public int min;
	public Elem next;
	
	public Elem(int value, int min) {
		this.value = value;
		this.min = min;
	}
}

public class MinStack {
	public Elem top;
	
	public MinStack() {
		
	}
	
	public void push(int x) {
		Elem e;
		
		if(top==null) top = new Elem(x,x);
		else {
			e = new Elem(x,Math.min(x, top.min));
			e.next = top;
			top = e;
		}
	}
	
	public void pop() {
		Elem temp;
		
		if(top == null) return;
		
		temp = top.next;
		top.next = null;
		top = temp;
	}
	
	public int top() {
		return top==null ? -1:top.value;
	}
	
	public int getMin() {
		return top==null ? -1:top.min;
	} 
	
	public static void main (String[] arg) {
		MinStack min = new MinStack();
		min.push(-2);
		min.push(0);
		min.push(-3);
		
		System.out.println(min.getMin());
		min.pop();
		min.pop();
		min.getMin();
		
		System.out.println(min.getMin());
	}
}
