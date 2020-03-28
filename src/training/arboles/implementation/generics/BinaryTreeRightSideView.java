package training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
	static Nodo<Integer> root;
	
	public static List<Integer> rightSide(Nodo<Integer> root){
		List<Integer> visibleValues = new ArrayList<>();
		
		if (root == null) return visibleValues;
		
		Queue<Nodo<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				Nodo<Integer> n = queue.poll();
				
				if(i == size-1) {
					visibleValues.add(n.getData());
				}
				
				if(n.getLeft() != null) queue.offer(n.getLeft());
				if(n.getRight() != null) queue.offer(n.getRight());
			}
		}
		
		return visibleValues;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(9));
		root.setRight(new Nodo<Integer>(20));
		root.getRight().setLeft(new Nodo<Integer>(15));
		root.getRight().setRight(new Nodo<Integer>(7));
		
		System.out.println(rightSide(root));
	}

}
