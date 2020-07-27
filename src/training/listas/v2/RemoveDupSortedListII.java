package training.listas.v2;

import training.listas.enlazadas.Nodo;

public class RemoveDupSortedListII {
	
	static Nodo<Integer> head;

	public static Nodo<Integer> deleteDuplicates(Nodo<Integer> head){
		Nodo<Integer> pre = new Nodo<Integer>(-1);
		pre.setNext(head);
		Nodo<Integer> cur = head;
		
		while(cur != null) {
			Nodo<Integer> temp = cur.getNext();
			boolean del = false;
			
			while(temp != null && cur.getDato() == temp.getDato()) {
				temp = temp.getNext();
				del = true;
			}
			
			if(del) {
				pre.setNext(temp);
				if(cur == head) head = temp;
				del = false;
				
			}
			else {
				pre = pre.getNext();
			}
			cur = temp;
		}
		return head;
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
	
	public static void printList() {
		if(head == null) return;
		
		for(Nodo aux=head;aux!=null;aux=aux.getNext())
			System.out.print(aux.getDato() + " > ");
		
		System.out.println("NULL");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		agregarNodoAlFinal(1);
		agregarNodoAlFinal(1);
		agregarNodoAlFinal(2);
		agregarNodoAlFinal(3);
		agregarNodoAlFinal(3);
		
		printList();
		
		head = deleteDuplicates(head);
		
		printList();
	}

}
