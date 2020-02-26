package itexico.training.listas.enlazadas;

import java.util.Stack;

public class PalindromeLinkedList {
	
	static Nodo<Integer> head;
	
	public static boolean isPalindrome(Nodo<Integer> head) {
		if(head == null || head.getNext() == null) return true;
		
		Stack<Integer> stack = new Stack<>();
		Nodo<Integer> slow = head;
		Nodo<Integer> fast = head;
		
		while(fast != null && fast.getNext() != null) {
			stack.push(slow.getDato());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		if(fast != null) slow = slow.getNext();
		
		while(slow != null){
			if(stack.pop() != slow.getDato()) return false;
			
			slow = slow.getNext();
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEnlazada l = new ListaEnlazada();
		l.agregarNodoAlFinal(3);
		l.agregarNodoAlFinal(2);
		l.agregarNodoAlFinal(2);
		l.agregarNodoAlFinal(3);
		
		l.print();
		
		System.out.println(isPalindrome(l.head));
		
	}

}

