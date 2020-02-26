package itexico.training.arboles.implementation.generics;

public class SymmetricTree {
	static Nodo<Integer> root;
	
	public static boolean isSymmetric(Nodo<Integer> root) {
		if(root == null) return true;
		
		return isSymmetric(root.getLeft(), root.getRight());
	}

	private static boolean isSymmetric(Nodo<Integer> left, Nodo<Integer> right) {
		// TODO Auto-generated method stub
		if(left == null || right == null) return left == right;
		
		if(left.getData() != right.getData()) return false;
		
		return isSymmetric(left.getLeft(), right.getRight()) 
				&& isSymmetric(left.getRight(),right.getLeft());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(1);
		root.setLeft(new Nodo<Integer>(2));
		root.setRight(new Nodo<Integer>(2));
		root.getLeft().setLeft(new Nodo<Integer>(3));
		root.getLeft().setRight(new Nodo<Integer>(4));
		root.getRight().setLeft(new Nodo<Integer>(4));
		root.getRight().setRight(new Nodo<Integer>(3));
		
		System.out.println(isSymmetric(root));
	}

}
