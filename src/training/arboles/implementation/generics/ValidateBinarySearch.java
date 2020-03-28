package training.arboles.implementation.generics;

public class ValidateBinarySearch {

	static Nodo<Long> root;
	
	public static boolean isValidBST(Nodo<Long> root) {
		if (root == null) return true;
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	
	private static boolean isValidBST(Nodo<Long> root, long min, long max) {
		if(root == null) return true;
		
		if(root.getData() <= min || root.getData() >= max) return false;
		
		return isValidBST(root.getLeft(),min,root.getData()) && isValidBST(root.getRight(),root.getData(),max);  
	}


	public static void main(String[] ar) {
		root = new Nodo<Long>((long) 5);
		root.setLeft(new Nodo((long) 1));
		root.setRight(new Nodo<Long>((long) 4));
		
		System.out.println(isValidBST(root));
	}
}
