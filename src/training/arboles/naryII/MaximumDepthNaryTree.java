package training.arboles.naryII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthNaryTree {
	
	static Nodo root;
	
	public static int maxDepth(Nodo root) {
		if (root == null) return 0;
		int depth = 0;
		Queue<Nodo> queue = new LinkedList<>();
		
		queue.offer(root);
	
		while(!queue.isEmpty()) {
			int size =queue.size();
			
			for(int i=0;i<size;i++) {
				Nodo current = queue.poll();
				
				for (Nodo child : current.getChildren()) {
					queue.offer(child);
				}
			}
			
			depth++;
		}
		
		
		return depth++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		System.out.println(maxDepth(root));
	}

}
