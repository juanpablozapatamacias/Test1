package training.arboles.implementation.generics;

import java.util.LinkedList;
import java.util.Queue;

class NodoTree<T>{
	public T dato;
	public NodoTree<Integer> left;
	public NodoTree<Integer> right;
	public NodoTree<Integer> next;
	
	public NodoTree() {}
	
	public NodoTree(T d) {
		this.dato = d;
	}
	
	
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoTree<Integer> getLeft() {
		return left;
	}
	public void setLeft(NodoTree<Integer> left) {
		this.left = left;
	}
	public NodoTree<Integer> getRight() {
		return right;
	}
	public void setRight(NodoTree<Integer> right) {
		this.right = right;
	}
	public NodoTree<Integer> getNext() {
		return next;
	}
	public void setNext(NodoTree<Integer> next) {
		this.next = next;
	}
}

public class PopulatiingNextRightPointersEachNode {
	static NodoTree<Integer> root;
	
	public static NodoTree<Integer> connect(NodoTree<Integer> root){
		if(root == null) return null;
		
		Queue<NodoTree<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			NodoTree<Integer> curr = queue.poll();
			
			if(curr == null && queue.isEmpty()) return root;
			else if(curr == null) {
				queue.add(null);
				continue;
			}
			else {
				curr.setNext(queue.peek());
				if(curr.getLeft() != null)
					queue.add(curr.getLeft());
				if(curr.getRight() != null)
					queue.add(curr.getRight());
			}
		}
		return root;
	}
	
	

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new NodoTree<Integer>(1);
		root.setLeft(new NodoTree<Integer>(2));
		root.setRight(new NodoTree<Integer>(3));
		
		NodoTree<Integer> res = connect(root);
	}

}
