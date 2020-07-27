package training.listas.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import training.listas.enlazadas.Nodo;

public class NextGreaterNodeLinkedList {
	
	static Nodo<Integer> head;
	
	public static void agregarNodoAlFinal(int dato) {
		if(head == null)
			head = new Nodo<Integer>(dato);
		else {
			Nodo<Integer> curr = head;
			while(curr.getNext()!=null) {
				curr = curr.getNext();
			}
			curr.setNext(new Nodo<Integer>(dato));
		}
	}
	
	public static void printList() {
		if(head == null) return;
		
		for(Nodo aux=head;aux!=null;aux=aux.getNext())
			System.out.print(aux.getDato() + " > ");
		
		System.out.println("NULL");
		System.out.println();
	}
	
	public static int[] nextLargerNode(Nodo<Integer> head) {
		ArrayList<Integer> nodeVals = new ArrayList<>();
		Nodo<Integer> current = head;
		
		while(current != null) {
			nodeVals.add(current.getDato());
			current = current.getNext();
		}
		
		int[] res = new int[nodeVals.size()];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<nodeVals.size();i++) {
			while(!stack.isEmpty() && nodeVals.get(stack.peek()) < nodeVals.get(i)) {
				res[stack.pop()] = nodeVals.get(i);
			}
			
			stack.push(i);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		agregarNodoAlFinal(2);
		agregarNodoAlFinal(1);
		agregarNodoAlFinal(5);
		
		printList();
		
		int[] A = nextLargerNode(head);
		System.out.println(Arrays.toString(A));
	}

}
