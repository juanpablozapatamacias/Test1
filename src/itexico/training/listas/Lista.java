package itexico.training.listas;

import java.util.HashSet;

public class Lista<D> {
	Nodo head;
	
	public <D> void insert(D dato){	
		Nodo new_node = new Nodo(dato);
		new_node.setSiguiente(head);
		head = new_node;
	}
	
	public <D> void insertAfter(Nodo prev, D dato) {
		if(prev == null) return;
		
		Nodo new_node =  new Nodo(dato);
		new_node.setSiguiente(prev.getSiguiente());	
		prev.setSiguiente(new_node);
	}
	
	public Nodo removeFirstNode(Nodo nodo) {
		if(nodo == null) return null;
		
		Nodo temp = nodo;
		nodo = nodo.getSiguiente();
		return nodo;
	} 
	
	public Nodo removeLastNode(Nodo nodo) {
		if(nodo == null) return null;
		
		if(nodo.getSiguiente() == null) return null;
		
		Nodo sec_last = nodo;
		while(sec_last.getSiguiente().getSiguiente() != null)
			sec_last = sec_last.getSiguiente();
		
		sec_last.setSiguiente(null);			
		return nodo;
	}
	
	public Nodo removeNthFromEnd(Nodo nodo, int position) {
		if(nodo == null) return null;
		
		Nodo aux = nodo;
		int len =0;
		while(aux != null) {
			len++;
			aux = aux.getSiguiente();
		}
		
		// remove 1st node
		int fromStart = len - position + 1;
		if(fromStart == 1) return nodo.getSiguiente();
		
		// remove non 1st node
		Nodo p = nodo;
		int i=0;
		while (p != null) {
			i++;
			if(i == fromStart-1) {
				p.setSiguiente(p.getSiguiente().getSiguiente());
			}
			p = p.getSiguiente();
		}
		return nodo;
	}
	
	public Nodo removeNodeAnyPostion(Nodo nodo, int position) {
		if(nodo == null) return null;
		Nodo aux = nodo;
		if (position == 0) return aux.getSiguiente();
		
		while(--position > 0) nodo = aux.getSiguiente();
		
		aux.setSiguiente(aux.getSiguiente().getSiguiente());
		
		return nodo;
	}
	
	public void printlist() {
		for (Nodo temp=head;temp!=null;temp=temp.getSiguiente())
			System.out.print(temp.getDato() + " ");
	}
	
	public Nodo reverse () {
		Nodo prev = null;
		Nodo curr = head;
		Nodo next = null;
		
		while(curr != null) {
			next = curr.getSiguiente();
			curr.setSiguiente(prev);
			prev = curr;
			curr = next;
		}
		head =  prev;
		
		return head;
	}
	
	public boolean cycleInList(Nodo n) {
		//Nodo n = lista.head;
		HashSet<Nodo> h = new HashSet<Nodo>();
		
		while(n !=null) {
			if (h.contains(n)) return true;
			
			h.add(n);
			n = n.getSiguiente();
		}
		
		return false;
	}
	/*
	public <D> Nodo reverseKGroup(Nodo nodo, D k) {
		
		if(nodo == null) return nodo;
		Nodo aux = new Nodo(0);
		
		aux.setSiguiente(nodo);
		
		Nodo prev = aux;
		int i=0;
		
		Nodo p = nodo;
		
		while(p != null) {
			i++;
			if(i%k ==0) {
				prev = reverse(prev, p.getSiguiente());
				p = prev.getSiguiente();
			}
			else p = p.getSiguiente();
		}

		return aux.getSiguiente();
	}

	public Nodo reverse(Nodo prev, Nodo siguiente) {
		// TODO Auto-generated method stub
		Nodo last = prev.getSiguiente();
		Nodo curr = last.getSiguiente();
		
		while (curr!=siguiente) {
			last.setSiguiente(curr.getSiguiente());
			curr.setSiguiente(prev.getSiguiente());
			prev.setSiguiente(curr);
			curr = last.getSiguiente();
		}
		return last;
	}
	
*/
}
