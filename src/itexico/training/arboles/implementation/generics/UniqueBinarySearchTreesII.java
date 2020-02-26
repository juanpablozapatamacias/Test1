package itexico.training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public static List<Nodo<Integer>> generateTrees(int n){
		if(n < 1) return new ArrayList<>();
		
		return generateTrees(1,n);
	}
	
	private static List<Nodo<Integer>> generateTrees(int low, int high) {
		// TODO Auto-generated method stub
		
		List<Nodo<Integer>> ans = new ArrayList<>();
		
		if(low > high) {
			ans.add(null);
			return ans;
		}
		
		for(int i=low;i<=high;i++) {
			List<Nodo<Integer>> leftSubTree = generateTrees(low, i-1);
			List<Nodo<Integer>> rightSubTree = generateTrees(i+1, high);
			
			for(Nodo<Integer> left : leftSubTree) {
				for(Nodo<Integer> right : rightSubTree) {
					Nodo<Integer> root = new Nodo<Integer>(i);
					root.setLeft(left);
					root.setRight(right);
					ans.add(root);
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateTrees(3));
	}

}
