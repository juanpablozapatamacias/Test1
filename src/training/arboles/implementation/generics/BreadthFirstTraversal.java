package training.arboles.implementation.generics;

import training.colas.implementation.generics.Queue;
import training.colas.implementation.generics.QueueOverflowException;
import training.colas.implementation.generics.QueueUnderflowException;

public class BreadthFirstTraversal {

	public static void breadthFirst(Nodo root) 
			throws QueueUnderflowException, QueueOverflowException{
		if (root == null) return;
		
		Queue<Nodo> queue = new Queue<>(Nodo.class);
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			Nodo node = queue.dequeue();
			System.out.println(node.getData());
			
			if(node.getLeft() != null) queue.enqueue(node.getLeft());
			if(node.getRight() != null) queue.enqueue(node.getRight());
		}
	}
}
