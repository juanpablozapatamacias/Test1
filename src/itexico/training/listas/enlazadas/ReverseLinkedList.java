package itexico.training.listas.enlazadas;

import java.util.Stack;

public class ReverseLinkedList {

	static Nodo<Integer> head;
	
	public static  Nodo<Integer> reverseList(Nodo<Integer> head){
		Stack<Nodo<Integer>> stack = new Stack<Nodo<Integer>>();
		Nodo<Integer> dummy;
		Nodo<Integer> current;
		
		while (head != null) {
			stack.push(head);
			head = head.getNext();
		}
		
		dummy = new Nodo<Integer>(-1);
		head = dummy;
		
		while(!stack.isEmpty()){
			current = stack.pop();
			head.setNext(new Nodo<Integer>(current.getDato()));
			head = head.getNext();
		}
		
		return dummy.getNext();
	}
	
	public static void main(String[] argv) {
		ListaEnlazada l = new ListaEnlazada();
		
		l.agregarNodoAlFinal(1);
		l.agregarNodoAlFinal(2);
		l.agregarNodoAlFinal(3);
		l.agregarNodoAlFinal(4);
		l.agregarNodoAlFinal(5);
		
		l.print();
		
		l.printList(reverseList(l.head));
		
		
	}
}
