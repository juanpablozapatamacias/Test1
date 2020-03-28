package training.listas.enlazadas.sorting;

public class AppRemoveMiddleNode {

	public static void main(String[] args) {
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		lista.insertAtEnd(1);
		lista.insertAtEnd(2);
		lista.insertAtEnd(3);
		lista.insertAtEnd(4);
		lista.insertAtEnd(5);
		
		
		lista.printlist();
		Nodo mid = lista.removeMiddleNode(lista.head);
		
		System.out.println(lista.removeMidNode(lista.head));
		
	}

}
