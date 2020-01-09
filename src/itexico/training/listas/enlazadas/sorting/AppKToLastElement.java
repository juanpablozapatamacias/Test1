package itexico.training.listas.enlazadas.sorting;

public class AppKToLastElement {

	public static void main(String[] args) {
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		
		lista.insertAtEnd(1);
		lista.insertAtEnd(2);
		lista.insertAtEnd(8);
		lista.insertAtEnd(3);
		lista.insertAtEnd(7);
		lista.insertAtEnd(0);
		lista.insertAtEnd(4);
		
		lista.printlist();
		
		System.out.println("Using iteration, 3rd Element from the end is " + lista.kthByIteration(lista.head, 3));
		System.out.println("Using recursion, 6th Element from the end is " + lista.kthByRecursion(lista.head, 6));
	}

}
