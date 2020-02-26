package itexico.training.arboles.implementation.generics.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversalNary {

	static NodoNary<Integer> root;
	
	public static void breadthNary(NodoNary<Integer> root) {
		if(root == null) return;
		
		Queue<NodoNary<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				NodoNary<Integer> temp = queue.poll();
				System.out.print(temp.getData() + " ");
				
				for(NodoNary<Integer> n : temp.getChildren())
					queue.add(n);
			}
		}
	}
	
	public static void main(String[] arg) {
		root = new NodoNary<Integer>(20);
		NodoNary n1 = new NodoNary<Integer>(2);
		NodoNary n2 = new NodoNary<Integer>(34);
		NodoNary n3 = new NodoNary<Integer>(50);
		NodoNary n4 = new NodoNary<Integer>(60);
		
		List<NodoNary<Integer>> l = new ArrayList<>();
		l.add(n1);
		l.add(n2);
		l.add(n3);
		l.add(n4);
		
		root.setChildren(l);
		
		breadthNary(root);
		
	}
}
