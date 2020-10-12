package training.dfs;

public class BalancedBinaryTree {
	static NodoTree<Integer> root;
	
	public static boolean isBalanced(NodoTree<Integer> root) {
		return depth(root) != -1;
	}
	
	public static int depth(NodoTree<Integer> root) {
		if(root == null) return 0;
		
		int left = depth(root.getLeft());
		if(left==-1) return -1;
		
		int right = depth(root.getRight());
		if(right==-1) return -1;
		
		if(Math.abs(left-right)>1) return -1;
		
		return 1 + Math.max(left,right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new NodoTree<>(3);
		root.setLeft(new NodoTree<>(9));
		root.setRight(new NodoTree<>(20));
		
		root.getRight().setLeft(new NodoTree<>(15));
		root.getRight().setRight(new NodoTree<>(7));
		
		System.out.println(isBalanced(root));
	}

}
