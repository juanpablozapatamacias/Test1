package training.listas.v2;

public class NodoTree<T> {

	private T dato;
	private NodoTree<T> left;
	private NodoTree<T> right;
	
	public NodoTree(T d) {
		this.dato = d;
		this.left = null;
		this.right = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoTree<T> getLeft() {
		return left;
	}

	public void setLeft(NodoTree<T> left) {
		this.left = left;
	}

	public NodoTree<T> getRight() {
		return right;
	}

	public void setRight(NodoTree<T> right) {
		this.right = right;
	}
	
	
	
}
