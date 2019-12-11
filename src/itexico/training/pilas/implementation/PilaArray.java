package itexico.training.pilas.implementation;

public class PilaArray implements Pila {
	
	private int top = -1;
	private Object s[];
	private int capacidad = 0;
	
	public PilaArray() {
		this(1000);
	}

	public PilaArray(int cap) {
		this.capacidad = cap;
		this.s = new Object[this.capacidad];
	}

	@Override
	public int longitud() {
		return (this.top + 1);
	}

	@Override
	public boolean esVacia() {
		return this.top < 0 ? true:false;
	}
	
	@Override
	public boolean esLlena() {
		return this.top >= this.capacidad ? true:false;
	}

	@Override
	public void push(Object o) {
		if(this.longitud() < this.capacidad) s[++top] = o;
	}

	@Override
	public Object pop() {
		Object aux;
		
		if(this.esVacia()) return null;
		
		aux = s[this.top];
		s[top--] = null;
		return aux;
	}

	@Override
	public Object primero() {
		if(this.esVacia()) return null;
		else return s[this.top];
	}

}
