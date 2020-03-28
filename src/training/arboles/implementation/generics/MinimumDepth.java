package training.arboles.implementation.generics;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
	static Nodo<Integer> root;
	
	public static int minDepth(Nodo root) {
		Queue<Nodo<Integer>> q = new LinkedList<>();
		
		if(root == null) return 0;
		if (root.getLeft() == null && root.getRight() == null) return 1;
		q.add(root);
		int d = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			d++;
			for(int i=0;i<size;i++) {
				Nodo<Integer> temp = q.poll();
				if(temp.getLeft() == null && temp.getRight() == null) return d;
				if(temp.getLeft() != null) q.add(temp.getLeft());
				if(temp.getRight() != null) q.add(temp.getRight());
			}
		}
		
		return 0;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(9));
		root.setRight(new Nodo<Integer>(20));
		
		root.getRight().setLeft(new Nodo<Integer>(15));
		root.getRight().setRight(new Nodo<Integer>(7));
		
		System.out.println(minDepth(root));
	}

}
