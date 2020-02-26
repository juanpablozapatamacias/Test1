package itexico.training.arboles.implementation.generics.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversalLevelOrder {
	
	static NodoNary<Integer> root;
	
	public static void zigzagLevelTrv(NodoNary<Integer> root) {
		if(root == null) return;
		
		Stack<NodoNary<Integer>> s1 = new Stack<>();
		Stack<NodoNary<Integer>> s2 = new Stack<>();
		Stack<NodoNary<Integer>> temp = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean isLeftToRight = false;
		
		s1.push(root);
		
		while(!s1.isEmpty()) {
			while(!s1.isEmpty()) {
				NodoNary<Integer> n = s1.pop();
				sb.append(n.getData());
				sb.append(' ');
				
				if(isLeftToRight) {
					for(int i=0; i<n.getChildren().size(); i++) {
						s2.push(n.getChildren().get(i));
					}
				}
				else {
					for(int i=n.getChildren().size()-1; i>-1; i--) {
						s2.push(n.getChildren().get(i));
					}
				}
			}
			System.out.println(sb.toString());
			sb.setLength(0);
			temp = s1;
			s1=s2;
			s2 = temp;
			isLeftToRight = !isLeftToRight;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new NodoNary<Integer>(20);
		NodoNary<Integer> n1 = new NodoNary<Integer>(2);
		NodoNary<Integer> n2 = new NodoNary<Integer>(34);
		NodoNary<Integer> n3 = new NodoNary<Integer>(50);
		NodoNary<Integer> n4 = new NodoNary<Integer>(60);
		NodoNary<Integer> n5 = new NodoNary<Integer>(70);
		
		NodoNary<Integer> n6 = new NodoNary<Integer>(15);
		NodoNary<Integer> n7 = new NodoNary<Integer>(20);
		
		NodoNary<Integer> n8 = new NodoNary<Integer>(30);
		
		NodoNary<Integer> n9 = new NodoNary<Integer>(40);
		NodoNary<Integer> n10 = new NodoNary<Integer>(100);
		NodoNary<Integer> n11 = new NodoNary<Integer>(20);
		
		List<NodoNary<Integer>> l = new ArrayList<>();
		l.add(n1);
		l.add(n2);
		l.add(n3);
		l.add(n4);
		l.add(n5);
		
		root.setChildren(l);
		
		List<NodoNary<Integer>> l1 = new ArrayList<>();
		l1.add(n6);
		l1.add(n7);
		
		root.getChildren().get(0).setChildren(l1);
		
		List<NodoNary<Integer>> l2 = new ArrayList<>();
		l2.add(n8);
		
		root.getChildren().get(1).setChildren(l2);
		
		List<NodoNary<Integer>> l3 = new ArrayList<>();
		l3.add(n9);
		l3.add(n10);
		l3.add(n11);
		
		root.getChildren().get(2).setChildren(l3);
		
		zigzagLevelTrv(root);
		
	}

}
