package training.listas.v2;

import training.listas.enlazadas.Nodo;

public class RemoveDupSortedList {

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
	
	public static Nodo<Integer> deleteDuplicates(Nodo<Integer> head){
		if(head == null) return null;
		
		Nodo<Integer> current = head;
		
		while(current != null && current.getNext() != null) {
			if(current.getNext().getDato() == current.getDato())
				current.setNext(current.getNext().getNext());
			else current = current.getNext();
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		agregarNodoAlFinal(1);
		agregarNodoAlFinal(1);
		agregarNodoAlFinal(2);
		agregarNodoAlFinal(3);
		agregarNodoAlFinal(3);
		
		printList();
		
		deleteDuplicates(head);
		
		printList();
	}

}
