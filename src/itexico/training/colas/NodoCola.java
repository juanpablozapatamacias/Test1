package itexico.training.colas;

public class NodoCola {
	private int dato;
	private NodoCola siguiente;
	
	public NodoCola(int d) {
		this.dato = d;
		this.siguiente = null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoCola getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoCola siguiente) {
		this.siguiente = siguiente;
	}

}
