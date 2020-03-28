package training.listas.enlazadas.sorting;

public class Nodo {

	private int dato;
	private Nodo next;
	
	public Nodo(int d) {
		this.dato = d;
		this.next = null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "El nodo contiene el dato: " + this.dato;
	}
	
}
