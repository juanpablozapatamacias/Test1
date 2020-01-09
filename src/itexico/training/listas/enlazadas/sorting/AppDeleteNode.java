package itexico.training.listas.enlazadas.sorting;

public class AppDeleteNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		
		lista.insertAtEnd(2);
		lista.insertAtEnd(3);
		lista.insertAtBeginning(1);
		lista.insertAtEnd(4);
		
		lista.printlist();
		lista.deleteNode(lista.head);
		lista.printlist();

	}

}
