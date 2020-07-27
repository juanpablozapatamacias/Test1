package training.listas.v2;

import training.listas.enlazadas.Nodo;

public class MiddleLinkedList {
	
	static Nodo<Integer> head;
	
	public static Nodo<Integer> middle(Nodo<Integer> head){
		if(head == null) return null;
		
		Nodo<Integer> fast = head;
		Nodo<Integer> slow = head;
		
		while(fast !=null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		return slow;
	}
	
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
	
	public static void printList(Nodo<Integer> nodo) {
		if(nodo == null) return;
		
		for(Nodo aux=nodo;aux!=null;aux=aux.getNext())
			System.out.print(aux.getDato() + " > ");
		
		System.out.println("NULL");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		agregarNodoAlFinal(1);
		agregarNodoAlFinal(2);
		agregarNodoAlFinal(3);
		agregarNodoAlFinal(4);
		agregarNodoAlFinal(5);
		
		printList(head);
		
		Nodo<Integer> res = middle(head);
		
		printList(res);
	}

}
