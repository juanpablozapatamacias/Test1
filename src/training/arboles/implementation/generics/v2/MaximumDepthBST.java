package training.arboles.implementation.generics.v2;

import java.util.Stack;

public class MaximumDepthBST {
	
	static Nodo<Integer> root;
	
	public static Nodo<Integer> insertNode(Nodo<Integer> head, Nodo<Integer> nodo) {
		if(head == null) return nodo;
		
		Nodo<Integer> aux;
		Nodo<Integer> padre;
		
		aux = head;
		
		while(true) {
			padre = aux;
			
			if(nodo.getData() <= aux.getData()) {
				aux = aux.getLeft();
				if(aux == null) {
					padre.setLeft(nodo);
					break;
				}
			}
			else {
				aux = aux.getRight();
				if(aux == null) {
					padre.setRight(nodo);
					break;
				}
			}
		}
		
		return head;
	}
	
	public static int maxDepthIterative(Nodo<Integer> root) {
		return Math.max(1 + maxDepthIterative(root,true), 1 + maxDepthIterative(root,false));
	}
	
	public static int minDepthIterative(Nodo<Integer> root) {
		return Math.min(1 + maxDepthIterative(root,true), 1 + maxDepthIterative(root,false));
	}
	
	private static int maxDepthIterative(Nodo<Integer> root, boolean left) {
		if(root == null) return 0;
		
		Stack<Nodo<Integer>> stack = new Stack<>();
		int depth = 0;
		stack.add(root);
		
		while(!stack.isEmpty()) {
			Nodo<Integer> n = stack.pop();
			
			if(left && n.getLeft() != null) stack.add(n.getLeft());
			if(left && n.getLeft() == null &&n.getRight() != null) stack.add(n.getRight());
			
			if(!left && n.getRight() != null) stack.add(n.getRight());
			if(!left && n.getRight() == null && n.getLeft()!=null) stack.add(n.getLeft());
			
			depth++;
		}
		
		return depth;
	}
	
	public static void main(String[] arg) {
		root = insertNode(root,new Nodo<Integer>(40));
		insertNode(root,new Nodo<Integer>(30));
		insertNode(root,new Nodo<Integer>(60));
		insertNode(root,new Nodo<Integer>(50));
		insertNode(root,new Nodo<Integer>(80));
		insertNode(root,new Nodo<Integer>(20));
		insertNode(root,new Nodo<Integer>(90));
		
		System.out.println(maxDepthIterative(root));
		System.out.println(minDepthIterative(root));
	}

}
