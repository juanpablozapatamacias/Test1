package itexico.training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrder {
	
	static Nodo<Integer> root;

	public static List<List<Integer>> zigzag(Nodo<Integer> root){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		if(root == null) return result;
		
		Stack<Nodo<Integer>> s1 = new Stack<>(); //left to right
		Stack<Nodo<Integer>> s2 = new Stack<>(); // right to left
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Nodo<Integer> n = s1.pop();
				list.add(n.getData());
				
				if(n.getLeft() != null) s2.push(n.getLeft());
				if(n.getRight() != null) s2.push(n.getRight());
			}
			
			if(!list.isEmpty()) result.add(new ArrayList<>(list));
			list.clear();
			
			while(!s2.isEmpty()) {
				Nodo<Integer> n = s2.pop();
				list.add(n.getData());
				
				if(n.getRight() != null) s1.push(n.getRight());
				if(n.getLeft() != null) s1.push(n.getLeft());
			}
			
			if(!list.isEmpty()) result.add(new ArrayList<>(list));
			list.clear();
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(9));
		root.setRight(new Nodo<Integer>(20));
		
		root.getRight().setLeft(new Nodo<Integer>(15));
		root.getRight().setRight(new Nodo<Integer>(7));
		
		System.out.println(zigzag(root));
	}

}
