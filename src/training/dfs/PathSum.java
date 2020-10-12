package training.dfs;

public class PathSum {
	static NodoTree<Integer> root;
	
	public static boolean hasPathSum(NodoTree<Integer> root, int sum) {
		if(root == null) return false;
		else if(root.getRight() == null && root.getLeft() == null && sum - root.getDato() == 0) return true;
		else return hasPathSum(root.getLeft(), sum - root.getDato()) || hasPathSum(root.getRight(), sum - root.getDato());
		
	}
	
	public static void main(String[] arg) {
		root = new NodoTree<Integer>(5);
		root.setLeft(new NodoTree<Integer>(4));
		root.setRight(new NodoTree<Integer>(8));
		
		root.getLeft().setLeft(new NodoTree<Integer>(11));
		root.getRight().setLeft(new NodoTree<Integer>(12));
		root.getRight().setRight(new NodoTree<Integer>(4));
		
		root.getLeft().getLeft().setLeft(new NodoTree<Integer>(7));
		root.getLeft().getLeft().setRight(new NodoTree<Integer>(2));
		
		root.getRight().getRight().setRight(new NodoTree<Integer>(1));
		
		int sum = 22;
		
		System.out.println(hasPathSum(root,sum));
	}

}
