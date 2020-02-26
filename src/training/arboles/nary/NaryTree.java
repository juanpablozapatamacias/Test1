package training.arboles.nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Nodo{
	public int val;
	public List<Nodo> children;
	
	public Nodo() {}
	
	public Nodo (int val, List<Nodo> children) {
		this.val = val;
		this.children = children;
	}
}

public class NaryTree {

	static List<Integer> nodes;
	
	public static List<Integer> preOrder(Nodo root){
		nodes = new ArrayList<>();
		preorderWalk(root);
		return nodes;
	}

	private static void preorderWalk(Nodo root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		
		nodes.add(root.val);
		
		for(Nodo nodo : root.children) {
			preorderWalk(nodo);
		}
	}
	
	public static List<Integer> postOrder(Nodo root){
		LinkedList<Nodo> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		
		if(root == null) return output;
		
		stack.add(root);
		
		while(!stack.isEmpty()) {
			Nodo nodo = stack.pollLast();
			output.addFirst(nodo.val);
			
			for(Nodo n : nodo.children) {
				stack.add(n);
			}
		}
		
		return output;
	}
	
	public static List<List<Integer>> levelOrder(Nodo root){
		
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		
		
		if(root == null) return res;
		if(root.children.size() == 0) {
			temp.add(root.val);
			res.add(temp);
			return res;
		}
		
		Queue<Nodo> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Nodo n = q.poll();
				temp.add(n.val);
				for (Nodo ni : n.children) {
					q.add(ni);
				}
			}
			res.add(new ArrayList<>(temp));
			temp.clear();
		}
		
		return res;
		
		
		/*
		List<List<Integer>> result = new ArrayList<>(); 
		
		if(root == null) return result;
		
		Queue<Nodo> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			
			for(int i=0;i<size;i++) {
				Nodo current = queue.poll();
				currentLevel.add(current.val);
				
				for(Nodo ni : current.children) {
					queue.add(ni);
				}
			}
			
			result.add(currentLevel);
			
		}
		
		return result;
		*/
	}
	
	public static void main(String[] ar) {
		Nodo root = new Nodo(1,null);
		List<Nodo> nodos = new ArrayList<>();
		
		nodos.add(new Nodo(3,null));
		nodos.add(new Nodo(2,null));
		nodos.add(new Nodo(4,null));
		
		root.children =nodos;
		
		List<Nodo> nodos1 = new ArrayList<>();
		nodos1.add(new Nodo(5,null));
		nodos1.add(new Nodo(6,null));
		
		root.children.get(0).children = nodos1;
		
		System.out.println(levelOrder(root));
	}
}
