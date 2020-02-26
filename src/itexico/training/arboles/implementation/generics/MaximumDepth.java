package itexico.training.arboles.implementation.generics;

public class MaximumDepth {
	static Nodo<Integer> root;
	
	public static int maximum(Nodo<Integer> root) {
		if(root == null) return 0;
		
		int left = maximum(root.getLeft());
		int right = maximum(root.getRight());
		
		return 1 + Math.max(left, right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(9));
		root.setRight(new Nodo<Integer>(20));
		
		root.getRight().setLeft(new Nodo<Integer>(15));
		root.getRight().setRight(new Nodo<Integer>(7));
		
		System.out.println(maximum(root));
	}

}
