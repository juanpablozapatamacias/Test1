package training.listas.enlazadas;

public class Nodo<T extends Comparable<T>>{

	private Nodo<T> next;
	private T dato;
	
	public Nodo(T dato) {
		this.dato = dato;
		this.next = null;
	}
	
	public Nodo<T> getNext() {
		return next;
	}
	
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	
	public T getDato() {
		return dato;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	@Override
	public String toString () {
		return String.valueOf(dato);
	}
	
	public int compareTo(T dato) {
		return this.dato.compareTo(dato);
	}
}
