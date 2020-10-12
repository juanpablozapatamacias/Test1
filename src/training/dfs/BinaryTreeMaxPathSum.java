package training.dfs;

public class BinaryTreeMaxPathSum {
	static NodoTree<Integer> root;
	static int max_path_sum;
	
	public static int maxPathSum(NodoTree<Integer> root) {
		max_path_sum = Integer.MIN_VALUE;
		pathSum(root);
		return max_path_sum;
	}
	
	private static int pathSum(NodoTree<Integer> root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		
		int left = Math.max(0, pathSum(root.getLeft()));
		int right = Math.max(0, pathSum(root.getRight()));
		
		max_path_sum = Math.max(max_path_sum, left + right + root.getDato());
		return Math.max(left, right) + root.getDato();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
