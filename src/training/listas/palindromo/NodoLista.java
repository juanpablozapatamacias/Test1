package training.listas.palindromo;

public class NodoLista<D> {
	private D dato;
	private NodoLista siguiente;
	
	public NodoLista(D d) {
		this.dato = d;
		this.siguiente = null;
	}

	public D getDato() {
		return dato;
	}

	public void setDato(D dato) {
		this.dato = dato;
	}

	public NodoLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLista siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String toString() {
		return this.getDato() + " esta en la pila";
	}
}
