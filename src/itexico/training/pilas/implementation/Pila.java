package itexico.training.pilas.implementation;

public interface Pila {
	public int longitud();
	public boolean esVacia();
	public boolean esLlena();
	public void push(Object o);
	public Object pop();
	public Object primero();
}
