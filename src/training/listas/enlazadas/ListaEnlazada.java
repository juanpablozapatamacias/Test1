package training.listas.enlazadas;

public class ListaEnlazada<T extends Comparable<T>> implements Cloneable{
	
	public Nodo<T> head = null;
	
	public ListaEnlazada() {}
	
	/*
	 * Insertar al final de la lista
	 * 
	 * @param nodo
	 * 
	 * */
	public void agregarNodoAlFinal(T dato) {
		if(head == null)
			head = new Nodo<T>(dato);
		else {
			Nodo<T> curr = head;
			while(curr.getNext()!=null) {
				curr = curr.getNext();
			}
			curr.setNext(new Nodo<T>(dato));
		}
	}
	
	/*
	 * Remover al principio de la lista
	 * 
	 * 
	 * */
	public T popElement() {
		Nodo<T> aux = head;
		T topElement = null;
		
		if(aux != null) {
			topElement = aux.getDato();
			aux = aux.getNext();
			
			return topElement;
		}
		
		return null;
	}
	
	
	/*
	 * Remover al frente de la lista
	 * 
	 * @param nodo
	 * 
	 * */
	public void remove() {
		if(head.getNext()!=null) head=head.getNext();
		else head = null;
	}
	
	/*
	 * Recorrer de manera recursiva la lista e imprimir el valor del nodo
	 * 
	 * @param nodo
	 * 
	 * */
	public void printList(Nodo<T> nodo) {
		System.out.println("Nodo es "+nodo.getDato());
		if(nodo.getNext()!=null) printList(nodo.getNext());
	} 
	
	public void print() {
		printList(head);
	}
	
	/*
	 * Contar los nodos de una lista
	 * 
	 * */
	
	public int countNodes() {
		if(head == null) return 0;
		
		Nodo<T> curr = head;
		int cont = 0;
		
		while(curr!=null) {
			curr = curr.getNext();
			cont++;
		}
		
		return cont;
	}
	
	/*
	 * Sort nodes in a list using merge sort 
	 *  
	 * @param nodo
	 * 
	 * */
	public Nodo<T> mergeSortLinkedList(Nodo<T> startNodo){
		Nodo<T> middle;
		Nodo<T> nextOfMiddle;
		Nodo<T> left;
		Nodo<T> right;
		Nodo<T> sortedList;
		
		// Break the list until list is null or only 1 element is present in List
		if(startNodo == null || startNodo.getNext() == null) return startNodo;
		
		// Break the list into two list
		// Finding the middle node and then breaking the linked list in 2 parts
		// Now we have 2 lists, one from start to middle and other from middle + 1 to end
		
		middle = getMiddle(startNodo);
		nextOfMiddle = middle.getNext();
		middle.setNext(null);
		
		// Continue break the linked list until there is only 1 element in each list
		left = mergeSortLinkedList(startNodo);
		right = mergeSortLinkedList(nextOfMiddle);
		
		// Once complete list is divided and contains only single element, needs to start the merge
		// left and right by sorting them and passing the sorted list further
		
		sortedList = mergeTwoListRecursive(left,right);
		
		return sortedList;
	}

	private Nodo<T> mergeTwoListRecursive(Nodo<T> left, Nodo<T> right) {
		// TODO Auto-generated method stub
		if(left == null) return right;
		if(right == null) return left;
		
		Nodo<T> temp = null;
		
		if(left.getDato().compareTo(right.getDato()) < 0) {
			temp = left;
			temp.setNext(mergeTwoListRecursive(left.getNext(),right));
		}
		else {
			temp = right;
			temp.setNext(mergeTwoListRecursive(left,right.getNext()));
		}
		
		return temp;
	}

	private Nodo<T> getMiddle(Nodo<T> startNodo) {
		// TODO Auto-generated method stub
		if(startNodo == null) return startNodo;
		
		Nodo<T> pt1 = startNodo;
		Nodo<T> pt2 = startNodo;
		
		while(pt2!=null && pt2.getNext()!=null && pt2.getNext().getNext()!=null) {
			pt1 = pt1.getNext();
			pt2 = pt2.getNext().getNext();
		}
		
		return pt1;
	}
	
	/**
	 * 
	 * Reverses the linked list
	 * 
	 * @param head
	 * @return Nodo<Integer>
	 * 
	 * **/
	public Nodo<T> reverse(Nodo<T> nodo){
		Nodo<T> prev = null;
		Nodo<T> curr = nodo;
		Nodo<T> next = null;
		
		while(curr !=null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		
		nodo = prev;
		return nodo;
	}
	

}
