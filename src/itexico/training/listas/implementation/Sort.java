package itexico.training.listas.implementation;

class Nodo {

	int dato;
	Nodo next;
	
	public Nodo(int d) {
		this.dato = d;
		this.next=null;
	}
} 

class Lista{
	Nodo head;
	Nodo nuevo;
	
	public void insert(int dato) {
		// Time comp - O(1)
		nuevo = new Nodo(dato);
		nuevo.next = head;
		head = nuevo;
	}
	
	public void insertAtEnd(int dato) {
		// Time comp - O(N)
		Nodo last;
		nuevo = new Nodo(dato);
		
		if(head == null) {
			head = new Nodo(dato);
		}
		
		nuevo.next = null;
		
		last = head;
		while(last.next != null) last = last.next;
		
		last.next = nuevo;
	}
	
	
	
	public void printList() {
		Nodo aux = head;
		while(aux != null) {
			System.out.print(aux.dato + " ");
			aux = aux.next;
		}
	}
	
	public Nodo reverse() {
		Nodo prev = null;
		Nodo curr = head;
		Nodo next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
}

public class Sort{

	private static Nodo getFirstEnd(Nodo head) {
		// Method that allow to get the list partition point
		Nodo p1 = head;
		Nodo p2 = head;
		
		while(p1 != null && p2 != null) {
			if(p2.next == null || p2.next.next == null) return p1;
			
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return head;
	}
	
	private static Nodo merge(Nodo n1, Nodo n2) {
		Nodo head = new Nodo(0);
		Nodo p = head;
		Nodo p1 = n1;
		Nodo p2 = n2;
		
		while(p1!=null && p2!=null) {
			if(p1.dato < p2.dato) {
				p.next = p1;
				p1 = p1.next;
			}
			else {
				p.next = p2;
				p2 = p2.next;
			}
			p=p.next;
		}
		
		if(p1!=null) p.next = p1;
		if(p2!=null) p.next = p2;
		
		return head.next;
	}
	
	public static Nodo sortList(Nodo head) {
		if(head == null || head.next == null) return head;
		
		Nodo p1 = head;
		Nodo firstEnd = getFirstEnd(head);
		Nodo p2 = firstEnd.next;
		
		p1 = sortList(p1);
		p2 = sortList(p2);
		
		return merge(p1,p2);
	}
	
	public static void main(String[] arg) {
		Nodo head;
		
		System.out.println("Linked List initialized");
		
		Lista l = new Lista();
		
		System.out.println("Adding values to the linked list");
		l.insert(3);
		l.insert(1);
		l.insert(5);
		l.insert(2);
		
		System.out.println("Print Linked List");
		l.printList();
		
		System.out.println("Applying reverse linked list ");
		head = l.reverse();
		
		System.out.println("Print again the Linked List\n");
		l.printList();
		
		System.out.println("Sorting the list, by applying the merge sort");
		head = sortList(head);
	}
}


