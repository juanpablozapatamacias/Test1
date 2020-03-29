package training.arboles.implementation.generics.v2;

public class ValidateBinarySearchTree {
	
	static Nodo<Integer> root;
	
	public static boolean isValidBST(Nodo<Integer> root) {
		return validate(root, null, null);
	}
	
	private static boolean validate(Nodo<Integer> root, Integer max, Integer min) {
		// TODO Auto-generated method stub
		if(root == null) return true;
		else if(max != null && root.getData() >= max || min !=null && root.getData() <= min) return false;
		else return validate(root.getLeft(),root.getData(),min) && validate(root.getRight(),max,root.getData());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(5);
		root.setLeft(new Nodo<Integer>(2));
		root.setRight(new Nodo<Integer>(7));
		
		root.getLeft().setLeft(new Nodo<Integer>(4));
		root.getLeft().setRight(new Nodo<Integer>(3));
		
		root.getRight().setLeft(new Nodo<Integer>(2));
		
		System.out.println(isValidBST(root));
	}

}
