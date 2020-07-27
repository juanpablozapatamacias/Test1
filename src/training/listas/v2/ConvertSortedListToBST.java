package training.listas.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import training.listas.enlazadas.Nodo;

public class ConvertSortedListToBST {
	static Nodo<Integer> h;
	
	public static int countNodes(Nodo<Integer> head) {
		if(head == null) return 0;
		
		int cont = 0;
		Nodo<Integer> temp = head;
		
		while(temp != null) {
			temp = temp.getNext();
			cont ++;
		}
		
		return cont;
	}
	
	public static NodoTree<Integer> sortedListBST(Nodo<Integer> head){
		if(head == null) return null;
		h = head;
		int len = countNodes(head);
		
		return sortedListBST(0, len-1);
	}

	private static NodoTree<Integer> sortedListBST(int start, int end) {
		// TODO Auto-generated method stub
		if(start > end) return null;
		
		int mid = (start + end) >> 1;
		
		NodoTree<Integer> left = sortedListBST(start, mid-1);
		NodoTree<Integer> root = new NodoTree<Integer>(h.getDato());
		h = h.getNext();
		NodoTree<Integer> right = sortedListBST(mid+1, end);
		
		root.setLeft(left);
		root.setRight(right);
		
		return root;
		
	}

	public static void agregarNodoAlFinal(int dato) {
		if(h == null)
			h = new Nodo<Integer>(dato);
		else {
			Nodo<Integer> curr = h;
			while(curr.getNext()!=null) {
				curr = curr.getNext();
			}
			curr.setNext(new Nodo<Integer>(dato));
		}
	}
	
	public static void printList() {
		if(h == null) return;
		
		for(Nodo aux=h;aux!=null;aux=aux.getNext())
			System.out.print(aux.getDato() + " > ");
		
		System.out.println("NULL");
		System.out.println();
	}
	
	public static List<Integer> inOrder(NodoTree<Integer> root) {
		List<Integer> res = new ArrayList<>();
		
		if(root == null) return res;
		
		Stack<NodoTree<Integer>> stack = new Stack<>();
		NodoTree<Integer> temp =  root;
		
		while(temp != null || !stack.isEmpty()) {
			
			while(temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			}
			
			temp = stack.pop();
			res.add(temp.getDato());
			
			temp = temp.getRight();
		}
		
		return res;
	}
	
	public static void main(String[] arg) {
		agregarNodoAlFinal(1);
		agregarNodoAlFinal(2);
		agregarNodoAlFinal(3);
		agregarNodoAlFinal(4);
		agregarNodoAlFinal(5);
		agregarNodoAlFinal(6);
		
		Nodo<Integer> list = h;
		printList();
		
		NodoTree<Integer> res = sortedListBST(list);
		System.out.println(inOrder(res));
	}
	
	
}
