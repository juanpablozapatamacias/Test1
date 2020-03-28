package training.listas.palindromo;


public class Lista<D> {
	NodoLista head;
	
	public <D> void insert(D dato){	
		NodoLista new_node = new NodoLista(dato);
		new_node.setSiguiente(head);
		head = new_node;
	}
	
	public NodoLista reverse(NodoLista head) {
		NodoLista prev = null;
		NodoLista curr = head;
		NodoLista next = null;
		
		while(curr != null) {
			next = curr.getSiguiente();
			curr.setSiguiente(prev);
			prev = curr;
			curr = next;
		}
		
		head = prev;
		return head;
	}
	
	public boolean compareLists(NodoLista n1, NodoLista n2) {
		NodoLista temp1 = n1;
		NodoLista temp2 = n2;
		
		while(temp1 != null && temp2 != null){
			if(temp1.getDato() == temp2.getDato()) {
				temp1 = temp1.getSiguiente();
				temp2 = temp2.getSiguiente();
			}
			else return false;
		}
		
		if (temp1 == null && temp2 == null)
			return true;
		
		return false;
	}
	
	public boolean isPalindromeRev(NodoLista head) {
		NodoLista slow = head;
		NodoLista fast = head;
		NodoLista sec_half;
		NodoLista midnode = null;
		NodoLista prev_slow=head;
		boolean band = true;
		
		if (head != null && head.getDato() != null) {
			while(fast !=null && fast.getSiguiente() != null) {
				fast = fast.getSiguiente().getSiguiente();
				prev_slow = slow;
				slow  = slow.getSiguiente();
			}
			
			if(fast !=null) {
				midnode = slow;
				slow = slow.getSiguiente();
			}
			
			sec_half = slow;
			prev_slow = null;
			sec_half = reverse(sec_half);
			
			band = compareLists(head, sec_half);
			
			sec_half = reverse(sec_half);
			
			if(midnode != null) {
				prev_slow = midnode;
				midnode.setSiguiente(sec_half);
			}
			else {
				prev_slow = sec_half;
			}
		}
		return band;
	}
	
	public void printList(NodoLista n) {
		while(n != null) {
			System.out.print(n.getDato() + "->");
			n = n.getSiguiente();
		}
		System.out.println("NULL");
	}
	
	
}
