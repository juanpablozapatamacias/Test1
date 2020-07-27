package training.listas.v2;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	static Nodo<Integer> head;
	
	public static Nodo<Integer> mergeKLists(Nodo<Integer>[] lists){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(Nodo<Integer> head : lists) {
			while(head != null) {
				minHeap.add(head.getDato());
				head  = head.getNext();
			}
		}
		
		Nodo<Integer> dummy = new Nodo<Integer>(-1);
		Nodo<Integer> head = dummy;
		
		while(!minHeap.isEmpty()) {
			head.setNext(new Nodo<Integer>(minHeap.remove()));
			head = head.getNext();
		}
		
		return dummy.getNext();
	}
	
	public static Nodo<Integer> agregaFinal(int dato) {
		if(head == null) 
			head = new Nodo<Integer>(dato);
		else {
			Nodo<Integer> curr = head;
			while(curr.getNext() != null) 
				curr = curr.getNext();
				
			curr.setNext(new Nodo<Integer>(dato));
		}
		
		return head;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nodo<Integer> res = null;
		
		Nodo<Integer> l1 = new Nodo<Integer>(2);
		l1.setNext(new Nodo<Integer>(4));
		l1.getNext().setNext(new Nodo<Integer>(6));
		
		Nodo<Integer> l2 = new Nodo<Integer>(1);
		l2.setNext(new Nodo<Integer>(3));
		l2.getNext().setNext(new Nodo<Integer>(5));
		//l2 = agregaFinal(7);
		
		printlist(l1);
	    printlist(l2);
		
	    Nodo[] arr = {l1,l2};
	    
	    res = mergeKLists(arr);
	    
	    printlist(res);
		
	}

}
