package training.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class SameTreeV2 {

	public static boolean isSameTree(NodoTree<Integer> p, NodoTree<Integer> q) {
		Queue<NodoTree<Integer>> queue = new LinkedList<>();
		queue.offer(p);
		queue.offer(q);
		
		while(!queue.isEmpty()) {
			NodoTree<Integer> first = queue.poll();
			NodoTree<Integer> second = queue.poll();
			
			if(first == null && second == null) continue;
			if(first == null || second == null) return false;
			
			if(first.getDato() != second.getDato()) return false;
			
			queue.offer(first.getLeft());
			queue.offer(second.getLeft());
			queue.offer(first.getRight());
			queue.offer(second.getRight());
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodoTree<Integer> a = new NodoTree<>(1);
		a.setLeft(new NodoTree<>(2));
		a.setRight(new NodoTree<>(3));
		
		NodoTree<Integer> b = new NodoTree<>(1);
		b.setLeft(new NodoTree<>(2));
		b.setRight(new NodoTree<>(3));
		
		System.out.println(isSameTree(a,b));
	}

}
