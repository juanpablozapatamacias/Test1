package training.arboles.implementation.generics;

public class Traversal {
	
	static Nodo<Character> raiz;
	
	public static void preOrder(Nodo<Character> root) {
		if(root == null) return;
		
		System.out.print(root.getData() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	public static void inOrder(Nodo<Character> root) {
		if(root == null) return;
		
		inOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrder(root.getRight());
	}
	
	public static void postOrder(Nodo<Character> root) {
		if(root == null) return;
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+ " ");
	}
	
	public static void addNode(Character c) {
		Nodo<Character> nuevo = new Nodo(c);
		Nodo<Character> aux;
		Nodo<Character> padre;
		
		if(raiz == null) raiz = nuevo;
		else {
			aux = raiz;
			while(true) {
				padre = aux;
				if(c < aux.getData()) {
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
		addNode('b');
		addNode('a');
		addNode('c');
		
		postOrder(raiz);
		inOrder(raiz);
		preOrder(raiz);
	}

}
