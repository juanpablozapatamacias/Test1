package training.arboles;

public class NodoArbol {
	
	private int dato;
	private String nombre;
	private NodoArbol izq;
	private NodoArbol der;
	
	public NodoArbol(int d, String nom) {
		this.dato = d;
		this.nombre = nom;
		this.izq=null;
		this.der=null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public NodoArbol getIzq() {
		return izq;
	}

	public void setIzq(NodoArbol izq) {
		this.izq = izq;
	}

	public NodoArbol getDer() {
		return der;
	}

	public void setDer(NodoArbol der) {
		this.der = der;
	}
	
	public String toString() {
		return this.getNombre() + " su dato es " + this.getDato();
	}

}
