package training.dfs;

import java.util.Stack;

public class FlattenBinaryTreeLinkedList {
	static NodoTree<Integer> root;
	
	public static void flatten(NodoTree<Integer> root) {
		if(root == null) return;
		
		Stack<NodoTree<Integer>> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			NodoTree<Integer> current = stack.pop();
			if(current.getRight() != null) stack.push(current.getRight());
			if(current.getLeft() != null) stack.push(current.getLeft());
			
			if(!stack.isEmpty()) current.setRight(stack.peek());
			
			current.setLeft(null);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		root = new NodoTree<>(3);
		root.setLeft(new NodoTree<>(9));
		root.setRight(new NodoTree<>(20));
		
		root.getRight().setLeft(new NodoTree<>(15));
		root.getRight().setRight(new NodoTree<>(7));
		
		flatten(root);
	}

}
