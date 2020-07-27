package training.listas.v2;

public class Nodo<T> {

	Nodo<T> head;

	private T dato;
	private Nodo<T> next;
	
	public Nodo(T d) {
		this.dato = d;
		this.next = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

		
	
}
