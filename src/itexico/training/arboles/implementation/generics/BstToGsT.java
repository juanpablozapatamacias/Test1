package itexico.training.arboles.implementation.generics;

public class BstToGsT {
	static Nodo<Integer> raiz;
	static int sum = 0;
	
	public static void preOrder(Nodo<Integer> root) {
		if(root == null) return;
		
		System.out.print(root.getData() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	public static void inOrder(Nodo<Integer> root) {
		if(root == null) return;
		
		inOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrder(root.getRight());
	}
	
	public static void postOrder(Nodo<Integer> root) {
		if(root == null) return;
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+ " ");
	}
	
	public static Nodo<Integer> transform(Nodo<Integer> raiz) {
		if(raiz.getRight() != null) transform(raiz.getRight());
		raiz.setData(sum + raiz.getData());
		sum = raiz.getData();
		if(raiz.getLeft() != null) transform(raiz.getLeft());
		return raiz;
	}
	
	public static void addNode(Integer d) {
		Nodo<Integer> nuevo = new Nodo(d);
		Nodo<Integer> aux;
		Nodo<Integer> padre;
		
		if(raiz == null) raiz = nuevo;
		else {
			aux = raiz;
			while(true) {
				padre = aux;
				if(d < aux.getData()) {
					aux = aux.getLeft();
					if(aux == null) {
						padre.setLeft(nuevo);
						return;
					}
				}
				else {
					aux = aux.getRight();
					if(aux == null) {
						padre.setRight(nuevo);
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addNode(4);
		addNode(1);
		addNode(6);
		addNode(0);
		addNode(2);
		addNode(3);
		addNode(5);
		addNode(7);
		addNode(8);
		
		preOrder(raiz);
		
		Nodo<Integer> res = transform(raiz);
		
		preOrder(res);
	}

}
