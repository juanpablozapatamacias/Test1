package training.listas.v2;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLinkedLists {
	
	public static Nodo<Integer> getIntersection(Nodo<Integer> headA, Nodo<Integer> headB){
		Set<Nodo<Integer>> visited = new HashSet<>();
		
		while(headA != null) {
			visited.add(headA);
			headA = headA.getNext();
		}
		
		while(headB != null) {
			if(visited.contains(headB)) return headB;
			
			headB = headB.getNext();
		}
		
		return null;
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
		Nodo<Integer> l1 = new Nodo<Integer>(5);
		l1.setNext(new Nodo<Integer>(4));
		l1.getNext().setNext(new Nodo<Integer>(1));
		l1.getNext().getNext().setNext(new Nodo<Integer>(2));
		
		Nodo<Integer> l2 = new Nodo<Integer>(3);
		l2.setNext(new Nodo<Integer>(1));
		l2.getNext().setNext(new Nodo<Integer>(2));
		
		Nodo<Integer> res = getIntersection(l1,l2);
		
		printlist(l1);
		printlist(l2);
		printlist(res);
	}

}
