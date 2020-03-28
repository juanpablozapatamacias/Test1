package training.arboles.implementation.generics.v2;

import java.util.ArrayList;
import java.util.List;

public class NodoNary<T> {
	
	private T data;
	private List<NodoNary<T>> children;
	
	public NodoNary(T d) {
		this.data = d;
		this.children = new ArrayList<>();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<NodoNary<T>> getChildren() {
		return children;
	}

	public void setChildren(List<NodoNary<T>> children) {
		this.children = children;
	}


}
