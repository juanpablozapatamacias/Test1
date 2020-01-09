package itexico.training.pilas.notacionpolaca;

public class PilaArray implements IPila {
	
	private int top = -1;
	private Object[] s;
	private int capacidad = 0;
	
	public PilaArray() {
		this(1000);
	}
	
	public PilaArray(int c) {
		this.capacidad = c;
		this.s = new Object[1000];
	}

	@Override
	public void push(Object o) {
		if(this.longitud() < this.capacidad)
			s[++top] = o;
	}

	@Override
	public Object pop() {
		Object aux;
		if(this.esVacia()) return null;
		
		aux = s[top];
		s[top--] = null;
		
		return aux;
	}

	@Override
	public Object top() {
		if(this.esVacia()) return null;
		else return s[top];
	}

	@Override
	public int longitud() {
		return this.top + 1;
	}

	@Override
	public boolean esVacia() {
		return top < 0;
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		
	}

}
