package itexico.training.listas.enlazadas.sorting;

public class AppFindInTheMiddle {

	public static void main(String[] ar)
	{
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		lista.insertAtEnd(1);
		lista.insertAtEnd(2);
		lista.insertAtEnd(3);
		lista.insertAtEnd(4);
		
		lista.printlist();
		
		Nodo mid = lista.findMiddleNode(lista.head);
		
		lista.printlist(mid);
	}
}
