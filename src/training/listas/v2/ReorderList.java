package training.listas.v2;

public class ReorderList {
	
	static Nodo<Integer> head;
	
	public static void reorder(Nodo<Integer> head) {
		if(head == null || head.getNext() == null) return;
		
		Nodo<Integer> l1 = head;
		
		Nodo<Integer> fast = head;
		Nodo<Integer> slow = head;
		
		Nodo<Integer> prev =null;
		
		while(fast != null && fast.getNext() != null) {
			prev = slow;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		prev.setNext(null);
		
		Nodo<Integer> l2 = reverse(slow);
		
		merge(l1,l2);
	}
	
	private static void merge(Nodo<Integer> l1, Nodo<Integer> l2) {
		// TODO Auto-generated method stub
		while(l1 != null) {
			Nodo<Integer> l1_next = l1.getNext();
			Nodo<Integer> l2_next = l2.getNext();
			
			l1.setNext(l2);
			
			if(l1_next == null) break;
			
			l2.setNext(l1_next);
			l1 = l1_next;
			l2 = l2_next;
		}
		
	}

	public static Nodo<Integer> reverse(Nodo<Integer> head){
		Nodo<Integer> prev = null;
		while(head != null) {
			Nodo<Integer> next = head.getNext();
			head.setNext(prev);
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	public static void agregarAlFinal(int dato) {
		if(head == null) head = new Nodo<Integer>(dato);
		else {
			Nodo<Integer> curr = head;
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			
			curr.setNext(new Nodo<Integer>(dato));
		}
	}
	
	public static void printlist(Nodo<Integer> head) {
		if(head == null) return;
		Nodo<Integer> aux = head;
		
		while(aux != null) {
			System.out.print(aux.getDato() + " > ");
			aux = aux.getNext();
		}
		
		System.out.println("NULL");
		System.out.println();
	}

	public static void main(String[] arg) {
		agregarAlFinal(1);
		agregarAlFinal(2);
		agregarAlFinal(3);
		agregarAlFinal(4);
		agregarAlFinal(5);
		agregarAlFinal(6);
		
		printlist(head);
		
		reorder(head);
		
		printlist(head);
	}
}
