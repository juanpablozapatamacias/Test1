package training.arboles.implementation.generics.v2;

import java.util.Stack;

public class ValidateBinarySearchTreeIt {
	
	static Nodo<Integer> root;
	
	public static boolean isValidBST(Nodo<Integer> root) {
		if (root == null) return true;
		
		Stack<Nodo<Integer>> stack = new Stack<>();
		Nodo<Integer> curr = root;
		double inord = - Double.MAX_VALUE;
		
		// Traverse in order
		while(curr != null || stack.size() > 0) {
			
			/* Reach the left most Node of the curr Node */
			while(curr != null) {
				stack.push(curr);
				curr = curr.getLeft();
			}
			
			curr = stack.pop();
			
			if(curr.getData() <= inord) return false;
			
			//System.out.println(curr.getData() + " ");
			inord = curr.getData();
			
			curr = curr.getRight();
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(5);
		root.setLeft(new Nodo<Integer>(2));
		root.setRight(new Nodo<Integer>(7));
		
		root.getLeft().setLeft(new Nodo<Integer>(1));
		root.getLeft().setRight(new Nodo<Integer>(3));
		
		root.getRight().setLeft(new Nodo<Integer>(2));
		
		System.out.println(isValidBST(root));
	}

}
