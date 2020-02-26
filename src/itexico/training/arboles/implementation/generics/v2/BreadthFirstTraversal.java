package itexico.training.arboles.implementation.generics.v2;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {
	
	static Nodo<Integer> root;
	
	public static void breadthFirstTraversal(Nodo<Integer> root) {
		if(root == null) return;
		
		Queue<Nodo<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i=0;i<size;i++) {
				Nodo<Integer> temp = queue.poll();
				System.out.print(temp.getData() + " ");
				
				if(temp.getLeft() != null) queue.offer(temp.getLeft());
				if(temp.getRight() != null) queue.offer(temp.getRight());
				
			}
		}
	}

	public static void main(String[] argv) {
		root = new Nodo<Integer>(5);
		root.setLeft(new Nodo<Integer>(2));
		root.setRight(new Nodo<Integer>(7));
		
		root.getLeft().setLeft(new Nodo<Integer>(1));
		root.getLeft().setRight(new Nodo<Integer>(3));
		
		root.getRight().setLeft(new Nodo<Integer>(2));
		
		breadthFirstTraversal(root);
	}
}
