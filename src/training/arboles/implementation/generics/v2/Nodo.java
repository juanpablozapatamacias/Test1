package training.arboles.implementation.generics.v2;

public class Nodo<T> {
	private T data;
	private Nodo<T> left;
	private Nodo<T> right;
	
	public Nodo(T d) {
		this.data = d;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Nodo<T> getLeft() {
		return left;
	}

	public void setLeft(Nodo<T> left) {
		this.left = left;
	}

	public Nodo<T> getRight() {
		return right;
	}

	public void setRight(Nodo<T> right) {
		this.right = right;
	}

}
