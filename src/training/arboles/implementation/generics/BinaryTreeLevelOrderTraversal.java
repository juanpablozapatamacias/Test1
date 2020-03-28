package training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	static Nodo<Integer> root;
	
	public static List<List<Integer>> levelOrder(Nodo<Integer> root){
		List<List<Integer>> result = new ArrayList<>(); 
		
		if(root == null) return result;
		
		Queue<Nodo<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			
			for(int i=0;i<size;i++) {
				Nodo<Integer> current = queue.remove();
				currentLevel.add(current.getData());
				
				if(current.getLeft() != null) queue.add(current.getLeft());
				if(current.getRight() != null) queue.add(current.getRight());
			}
			
			result.add(currentLevel);
		}
		
		
		Collections.reverse(result);
		return result;
	}
	
	public static List<List<Integer>> levelBottomOrder(Nodo<Integer> root){
		Map<Integer,List<Integer>> m = new HashMap<>();
		helper(m,root,0);
		List<List<Integer>> res = new ArrayList<>(m.values());
		Collections.reverse(res);
		return res;
	}

	private static void helper(Map<Integer, List<Integer>> m, Nodo<Integer> root, int i) {
		// TODO Auto-generated method stub
		if(root == null) return;
		
		if(m.containsKey(i)) {
			m.get(i).add(root.getData());
		}
		else {
			List<Integer> l = new ArrayList<>();
			l.add(root.getData());
			m.put(i, l);
		}
		
		helper(m,root.getLeft(),i+1);
		helper(m,root.getRight(),i+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(9));
		root.setRight(new Nodo<Integer>(20));
		root.getRight().setLeft(new Nodo<Integer>(15));
		root.getRight().setRight(new Nodo<Integer>(7));
		
		System.out.println(levelOrder(root));
	}

}
