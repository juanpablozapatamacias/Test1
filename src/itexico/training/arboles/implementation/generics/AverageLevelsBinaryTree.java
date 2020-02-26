package itexico.training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {
	
	static Nodo<Integer> root;
	
	public static List<Double> average(Nodo<Integer> root){
		List<Double> res = new ArrayList<>();
		
		if(root == null) return res;
		
		Queue<Nodo<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		
		double level_sum = 0;
		
		while(!queue.isEmpty()) {
			level_sum =0;
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				Nodo<Integer> n = queue.poll();
				level_sum += n.getData();
				
				if(n.getLeft() != null) queue.offer(n.getLeft());
				if(n.getRight() != null) queue.offer(n.getRight());
			}
			
			double level_avg = level_sum / size;
			res.add(level_avg);
		}
		
		return res;
	}

	public static void main(String[] args) {
		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(1));
		root.setRight(new Nodo<Integer>(4));
		
		root.getRight().setLeft(new Nodo<Integer>(2));
		root.getRight().setRight(new Nodo<Integer>(5));
		
		System.out.println(average(root));
		

	}

}
