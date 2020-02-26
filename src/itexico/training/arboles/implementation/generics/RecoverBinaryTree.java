package itexico.training.arboles.implementation.generics;

public class RecoverBinaryTree {
	
	static Nodo<Integer> root;
	static Nodo<Integer> firstStartPoint;
	static Nodo<Integer> lastEndPoint;
	static Nodo<Integer> prevNode;
	
	public static void recover(Nodo<Integer> root){
		if(root == null) return;
		
		findSegments(root);
		
		if(lastEndPoint!=null && firstStartPoint!=null) {
			int val = lastEndPoint.getData();
			lastEndPoint.setData(firstStartPoint.getData());
			firstStartPoint.setData(val);
		}
	} 

	private static void findSegments(Nodo<Integer> root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		
		findSegments(root.getLeft());
		
		if(prevNode == null) prevNode = root;
		else {
			if(root.getData() < prevNode.getData()) {
				if(firstStartPoint == null) firstStartPoint = prevNode;
				
				lastEndPoint = prevNode;
			}
			prevNode = root;
		}
		
		findSegments(root.getRight());
	}
	
	private static void inOrder(Nodo<Integer> root) {
		if(root == null) return;
		
		inOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrder(root.getRight());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(10);
		root.setLeft(new Nodo<Integer>(15));
		root.setRight(new Nodo<Integer>(5));
		
		root.getLeft().setLeft(new Nodo<Integer>(4));
		root.getLeft().setRight(new Nodo<Integer>(7));
		
		root.getRight().setLeft(new Nodo<Integer>(14));
		root.getRight().setRight(new Nodo<Integer>(17));
		
		inOrder(root);
		
		recover(root);
		
		inOrder(root);
		
	}

}
