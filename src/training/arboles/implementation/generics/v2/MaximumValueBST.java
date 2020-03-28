package training.arboles.implementation.generics.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumValueBST {
	
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
	
	public static List<List<Integer>> getMaxVal(Nodo<Integer> root){
		List<List<Integer>> res = new ArrayList<>();
		
		if(root == null) return res;
		
		Queue<Nodo<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> l = new ArrayList<>();
			
			for(int i=0;i<size;i++) {
				Nodo<Integer> n = queue.poll();
				l.add(n.getData());
				
				if(n.getRight() != null) queue.offer(n.getRight());
			}
			
			res.add(l);
			
		}
		
		return res;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = insertNode(root,new Nodo<Integer>(40));
		insertNode(root,new Nodo<Integer>(30));
		insertNode(root,new Nodo<Integer>(60));
		insertNode(root,new Nodo<Integer>(50));
		insertNode(root,new Nodo<Integer>(80));
		insertNode(root,new Nodo<Integer>(20));
		insertNode(root,new Nodo<Integer>(90));
		
		System.out.println(getMaxVal(root));
	}

}
