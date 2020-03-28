package training.listas.enlazadas.sorting;

public class AppPartitionList {

	public static void main(String[] args) {
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		
		lista.insertAtEnd(1);
		lista.insertAtEnd(4);
		lista.insertAtEnd(3);
		lista.insertAtEnd(2);
		lista.insertAtEnd(5);
		lista.insertAtEnd(2);
		lista.insertAtEnd(3);
		
		lista.printlist();
		
		Nodo part = lista.partition(lista.head,3);
		
		lista.printlist();
	}

}
