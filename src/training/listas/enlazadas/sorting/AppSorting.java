package training.listas.enlazadas.sorting;

public class AppSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEnlazadaInt list = new ListaEnlazadaInt();
		list.insertAtBeginning(6);
		list.insertAtBeginning(4);
		list.insertAtBeginning(1);
		
		list.printlist();
		
		list.insertAtEnd(5);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		
		list.printlist();
		
		list.insertByPosition(4, 7);
		list.insertByPosition(2, 8);
		list.insertByPosition(0, 9);
		
		list.printlist();
		
		list.removeAtPosition(4);
		list.printlist();
		
		
		list.insertByPosition(0, 5);
		list.printlist();
		
		System.out.println(list.count(list.head,5));
		
		list.head= list.mergeSortLinkList(list.head);
		list.printlist();
		
		list.removeDuplicates();
		
		list.printlist();
		
	}

}
