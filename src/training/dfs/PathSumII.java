package training.dfs;

import java.util.List;
import java.util.ArrayList;

public class PathSumII {
	static NodoTree<Integer> root;
	
	public static List<List<Integer>> path(NodoTree<Integer> root, int sum){
		List<List<Integer>> res = new ArrayList<>();
		
		findPaths(root,sum,new ArrayList<Integer>(),res);
		
		return res;
	}

	private static void findPaths(NodoTree<Integer> root, int sum, List<Integer> current,
			List<List<Integer>> res) {
		if(root == null) return;
		
		current.add(root.getDato());
		if(root.getDato() == sum && root.getLeft() == null && root.getRight() == null) {
			res.add(current);
			return;
		}
		
		findPaths(root.getLeft(), sum - root.getDato(), new ArrayList<Integer>(current), res);
		findPaths(root.getRight(), sum - root.getDato(), new ArrayList<Integer>(current), res);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		System.out.println(path(root,sum));
	}

}
