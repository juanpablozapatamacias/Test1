package training.arboles.naryII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTree {
	
	static Nodo root;
	
	public static List<List<Integer>> levelOrder(Nodo root){
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) return result;
		
		Queue<Nodo> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> currentLevel = new ArrayList<>();
			
			for(int i=0;i<size;i++) {
				Nodo current = q.remove();
				currentLevel.add(current.getDato());
				
				for (Nodo no : current.getChildren())
					q.add(no);
			}
			
			result.add(currentLevel);
		}
		
		return result;
	}
	
	public static void main(String[] ar) {
		root = new Nodo(1);
		List<Nodo> nodos = new ArrayList<>();
		
		nodos.add(new Nodo(3));
		nodos.add(new Nodo(2));
		nodos.add(new Nodo(4));
		
		root.setChildren(nodos);
		
		List<Nodo> nodos1 = new ArrayList<>();
		nodos1.add(new Nodo(5));
		nodos1.add(new Nodo(6));
		
		root.getChildren().get(0).setChildren(nodos1);
		
		System.out.println(levelOrder(root));
	}

}
