package itexico.training.sorting.quicksort.linkedlist;

public class QuickSortLinkedList {
	
	Nodo head;
	
	public void addNode(int data) {
		if(head == null) {
			head = new Nodo(data);
			return;
		}
		
		Nodo curr = head;
		while(curr.getSiguiente()!=null) curr = curr.getSiguiente();
		
		Nodo newNodo = new Nodo(data);
		curr.setSiguente(newNodo);
	}
	
	public void printlist(Nodo n) {
		while(n!= null) {
			System.out.print(n.getDato() + " ");
			n = n.getSiguiente();
		}
	}
	
	private Nodo[] partition(Nodo start, Nodo end) {
		//start inclusive
		// end inclusive
		// return a new start node and pivot node
		
		if(start == null || start == end || start.getSiguiente()==end)
			return new Nodo[] {start,start};
		
		Nodo dummy = new Nodo(0);
		dummy.setSiguente(start);
		
		for(Nodo j=start; j!=null && j.getSiguiente()!=null && j.getSiguiente()!=end; j = j.getSiguiente()) {
			while(j.getSiguiente()!=null && j.getSiguiente().getDato() <= start.getDato()) {
				Nodo temp = j.getSiguiente();
				j.setSiguente(j.getSiguiente().getSiguiente());
				temp.setSiguente(dummy.getSiguiente());
				dummy.setSiguente(temp);
			}
		}
		
		return new Nodo[] {dummy.getSiguiente(),start};
	}
	
	private Nodo quick(Nodo start, Nodo end) {
		if(start==null || start == end || start.getSiguiente() == null)
			return start;
		
		Nodo[] result = partition(start,end);
		Nodo resultLeft = quick(result[0],result[1]);
		Nodo resultRight = quick(result[1].getSiguiente(),end);
		
		return resultLeft;
	}
	
	public Nodo quickSort(Nodo head) {
		if(head ==null || head.getSiguiente()==null)
			return head;
		
		return quick(head,null);
	}
	
	

}
