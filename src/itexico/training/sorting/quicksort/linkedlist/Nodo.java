package itexico.training.sorting.quicksort.linkedlist;

public class Nodo {
	
	private int dato;
	private Nodo siguiente;
	
	public Nodo(int d) {
		this.dato = d;
		this.siguiente = null;
	}
	
	public int getDato() {
		return dato;
	}
	
	public void setDato(int dato) {
		this.dato = dato;
	}
	
	public Nodo getSiguiente() {
		return siguiente;
	}
	
	public void setSiguente(Nodo siguente) {
		this.siguiente = siguente;
	}

}
