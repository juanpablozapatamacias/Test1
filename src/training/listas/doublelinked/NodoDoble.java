package training.listas.doublelinked;

public class NodoDoble {
	private int dato;
	private NodoDoble siguiente;
	private NodoDoble anterior;
	
	//Constructor para cuando no hay nodos
	public NodoDoble(int ele) {
		this(ele,null,null);
	}

	// Constructor para cuando hay nodos
	public NodoDoble(int ele, NodoDoble s, NodoDoble a) {
		this.dato = ele;
		this.siguiente = s;
		this.anterior = a;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoDoble getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}

	public NodoDoble getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}
	
}

