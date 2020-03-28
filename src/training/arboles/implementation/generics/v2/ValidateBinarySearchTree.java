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

	}

}
