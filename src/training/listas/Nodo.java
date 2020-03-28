package training.listas;

public class Nodo<D> {
	private D dato;
	private Nodo siguiente;
	
	public Nodo(D dato) {
		this.dato = dato;
	}
	
	public Nodo(Nodo n, D d) {
		this.dato = d;
		this.siguiente = n;
	}

	public D getDato() {
		return dato;
	}

	public void setDato(D dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	@Override
	public String toString() {
		return "Este nodo contiene el dato " + this.getDato();
	}

}
