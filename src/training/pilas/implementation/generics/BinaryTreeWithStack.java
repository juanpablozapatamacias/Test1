package training.pilas.implementation.generics;

import java.util.ArrayList;
import java.util.List;

class Nodo<T>{
	private T data;
	private Nodo left;
	private Nodo right;
	
	public Nodo(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Nodo getLeft() {
		return left;
	}

	public void setLeft(Nodo left) {
		this.left = left;
	}

	public Nodo getRight() {
		return right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}	
}

public class BinaryTreeWithStack {
	
	static Stack<Nodo> stack = new Stack<Nodo>();
	
	static List<Integer> returnList = new ArrayList<Integer>();
	
	static Nodo<Integer> n;
	static Nodo<Integer> raiz;
	
	public static void addNode(Integer d) {
		Nodo<Integer> nuevo = new Nodo(d);
		Nodo<Integer> aux;
		Nodo<Integer> padre;
		
		if(raiz == null) raiz = nuevo;
		else {
			aux = raiz;
			while(true) {
				padre = aux;
				if(d < aux.getData()) {
					aux = aux.getLeft();
					if(aux == null) {
						padre.setLeft(nuevo);
						return;
					} 
				}
				else {
					aux = aux.getRight();
					if(aux == null) {
						padre.setRight(nuevo);
						return;
					}
				}
			}
		}
	}
	
	public static List<Integer> preorderTraversal(Nodo<Integer> root) 
			throws StackOverflowException, StackUnderFlowException{
		if(root == null) return returnList;
		
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			n = stack.pop();
			returnList.add(n.getData());
			
			if(n.getRight() != null) stack.push(n.getRight());
			if(n.getLeft() != null) stack.push(n.getLeft());
		}
		
		return returnList;
	}
	
	public static List<Integer> inorderTraversal(Nodo<Integer> root)
			throws StackOverflowException, StackUnderFlowException{
		if(root == null) return returnList;
		
		Nodo<Integer> p = root;
		
		while(p!=null) {
			stack.push(p);
			p = p.getLeft();
		}
		
		while(!stack.isEmpty()) {
			n = stack.pop();
			returnList.add(n.getData());
			
			n = n.getRight();
			
			while(n != null) {
				stack.push(n);
				n = n.getLeft();
			}
		}
		
		return returnList;
	}
	
	public static List<Integer> postorderTraversal(Nodo<Integer> root)
			throws StackOverflowException, StackUnderFlowException{
		if(root == null) return returnList;
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Nodo<Integer> temp = stack.peek();
			
			if(temp.getLeft() == null && temp.getRight() == null) {
				Nodo<Integer> pop = stack.pop();
				returnList.add(pop.getData());
			}
			else {
				if(temp.getRight() != null) {
					stack.push(temp.getRight());
					temp.setRight(null);
				}
				if(temp.getLeft() != null) {
					stack.push(temp.getLeft());
					temp.setLeft(null);
				}
			}
		}
		return returnList;
	}
	
	
	public static void main(String[] args) throws StackOverflowException, StackUnderFlowException {
		// TODO Auto-generated method stub
		addNode(1);
		addNode(2);
		addNode(3);

		System.out.println(preorderTraversal(raiz));
		System.out.println(inorderTraversal(raiz));
		System.out.println(postorderTraversal(raiz));
	}

}
