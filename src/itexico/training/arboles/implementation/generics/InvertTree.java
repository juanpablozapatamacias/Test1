package itexico.training.arboles.implementation.generics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertTree<T> {

	Nodo<T> root;
	
	public Nodo<T> invertTreeIterative(Nodo<T> root){
		if(root == null) return null;
		
		Queue<Nodo<T>> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i=0;i<size;i++) {
				Nodo<T> curr = q.poll();
				Nodo<T> temp = curr.getLeft();
				curr.setLeft(curr.getRight());
				curr.setRight(temp);
				
				if(curr.getLeft() != null) q.offer(curr.getLeft());
				if(curr.getRight() != null) q.offer(curr.getRight());
			}
		}
		
		return root;
	}
	
	public void inOrder(Nodo<T> root) {
		if(root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrder(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvertTree<Integer> in = new InvertTree<>();
		in.root = new Nodo(4);
		in.root.setLeft(new Nodo(2));
		in.root.setRight(new Nodo(6));
		
		Nodo<Integer> res = in.invertTreeIterative(in.root);
		
		in.inOrder(res);
		
	}

}
