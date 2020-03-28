package training.sorting.quicksort.linkedlist;

public class AppQuickSortLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortLinkedList ql = new QuickSortLinkedList();
		
		ql.addNode(30);
		ql.addNode(10);
		ql.addNode(24);
		ql.addNode(11);
		ql.addNode(1);
		
		Nodo n = ql.head;
		
		while(n.getSiguiente()!=null) n = n.getSiguiente();
		
		System.out.println("Linked List before sorting");
		ql.printlist(ql.head);
		
		n= ql.quickSort(ql.head);
		
		System.out.println("\nLinked List before sorting");
		ql.printlist(n);
	}

}
