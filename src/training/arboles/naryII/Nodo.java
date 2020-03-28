package training.arboles.naryII;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private int dato;
	private List<Nodo> children;
	
	public Nodo(int data) {
		this.dato = data;
		this.children = new ArrayList<>();
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public List<Nodo> getChildren() {
		return children;
	}

	public void setChildren(List<Nodo> children) {
		this.children = children;
	}

}
