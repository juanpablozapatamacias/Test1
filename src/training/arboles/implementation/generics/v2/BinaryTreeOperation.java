package training.arboles.implementation.generics.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeOperation {
	
	static Nodo<Integer> root;
	
	public static Nodo<Integer> insertNode(Nodo<Integer> head, Nodo<Integer> nodo) {
		if(head == null) return nodo;
		
		/*
		if(nodo.getData() <= head.getData()) {
			head.setLeft(insertNode(head.getLeft(), nodo));
		} else {
			head.setRight(insertNode(head.getRight(), nodo));
		}*/
		
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
	
	public static Nodo<Integer> searchNode(Nodo<Integer> head, int val){
		if(head == null) return null;
		if(head.getData() == val) return head;
		
		/*
		Nodo<Integer> aux = head;
		
		while(aux.getData() != val) {
			if(val <= aux.getData())
				aux = aux.getLeft();
			else
				aux = aux.getRight();
		}
		
		return aux;*/
		
		if(val < head.getData()) return searchNode(head.getLeft(),val);
		else return searchNode(head.getRight(),val);
	}
	
	public static List<List<Integer>> invertTreeIterative(Nodo<Integer> root){
		List<List<Integer>> res = new ArrayList<>();
		
		
		if(root == null) return res;
		Queue<Nodo<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> l = new ArrayList<>();
			
			for(int i=0;i<size;i++) {
				Nodo<Integer> n = queue.poll();
				l.add(n.getData());
				
				Nodo<Integer> temp = n.getLeft();
				n.setLeft(n.getRight());
				n.setRight(temp);
				
				if(n.getLeft() != null) queue.offer(n.getLeft());
				if(n.getRight() != null) queue.offer(n.getRight());
			}
			res.add(l);
		}
		
		return res;
		
	}
	
	public static void inorderRecursive(Nodo<Integer> n) {
		if (n == null) return;
		
		inorderRecursive(n.getLeft());
		System.out.print(n.getData() + " ");
		inorderRecursive(n.getRight());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = insertNode(root,new Nodo<Integer>(40));
		insertNode(root,new Nodo<Integer>(30));
		insertNode(root,new Nodo<Integer>(60));
		insertNode(root,new Nodo<Integer>(50));
		insertNode(root,new Nodo<Integer>(80));
		
		inorderRecursive(root);
		System.out.println();
		inorderRecursive(searchNode(root,90));
		
		System.out.println();
		System.out.println(invertTreeIterative(root));
	}

}
