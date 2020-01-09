package itexico.training.listas.enlazadas.sorting;

public class AppSumList {

	public static void main(String[] args) {
		ListaEnlazadaInt l1 = new ListaEnlazadaInt();
		ListaEnlazadaInt l2 = new ListaEnlazadaInt();
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		
		l1.insertAtEnd(7);
		l1.insertAtEnd(1);
		l1.insertAtEnd(6);
		
		l1.printlist();
		
		l2.insertAtEnd(5);
		l2.insertAtEnd(9);
		l2.insertAtEnd(2);
		
		l2.printlist();
		
		Nodo sum = lista.sumLists(l1.head, l2.head);
		
		lista.printlist();
	}

}
