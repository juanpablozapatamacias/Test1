package itexico.training.pilasdinamicas;

public class NodoPila {
	private int dato;
	private NodoPila siguiente;
	
	public NodoPila (int d) {
		this.dato=d;
		this.siguiente=null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoPila getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoPila siguiente) {
		this.siguiente = siguiente;
	}
	
	@Override
	public String toString() {
		return this.getDato() + " esta en la pila";
	}

}
