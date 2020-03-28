package training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesReturnForest {

	static Nodo<Integer> root;
	
	public static List<Nodo<Integer>> delNodes(Nodo<Integer> root, int[] to_delete){
		List<Nodo<Integer>> remaining = new ArrayList<>();
		Set<Integer> toDelete = new HashSet<>();
		
		for(int i : to_delete) {
			toDelete.add(i);
		}
		
		removeNodes(root,toDelete,remaining);
		
		if(!toDelete.contains(root.getData())) remaining.add(root);
		
		return remaining;
	}
	
	private static Nodo<Integer> removeNodes(Nodo<Integer> root, Set<Integer> toDelete, List<Nodo<Integer>> remaining) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		
		root.setLeft(removeNodes(root.getLeft(),toDelete,remaining));
		root.setRight(removeNodes(root.getRight(),toDelete,remaining));
		
		if(toDelete.contains(root.getData())) {
			if(root.getLeft() != null) remaining.add(root.getLeft());
			if(root.getRight() != null) remaining.add(root.getRight());
			
			return null;
		}
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(1);
		root.setLeft(new Nodo<Integer>(2));
		root.setRight(new Nodo<Integer>(3));
		
		root.getLeft().setLeft(new Nodo<Integer>(4));
		root.getLeft().setRight(new Nodo<Integer>(5));
		
		root.getRight().setLeft(new Nodo<Integer>(6));
		root.getRight().setLeft(new Nodo<Integer>(7));
		
		int[] del = {3,5};
		
		System.out.println(delNodes(root,del));
	}

}
