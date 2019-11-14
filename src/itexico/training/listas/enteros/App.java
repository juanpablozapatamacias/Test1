package itexico.training.listas.enteros;

public class App {

	public static void main(String[] arg) {
		Lista l = new Lista();
		l.insert(1);
		l.insert(2);
		l.insert(4);
		l.insert(3);
		l.insert(5);
		l.printList();
		
		//l.removeNthFromEnd(l.head, 2);
		
		//l.printList();
		
		//l.insertNthPosition(2, 2);
		
		//l.printList();
		
		l.head = l.revKGroup(l.head, 3);
		
		l.printList();
		
		Lista l1 = new Lista();
		Lista l2 = new Lista();
		
		l1.insert(2);
		l1.insert(4);
		l1.insert(3);
		
		l2.insert(5);
		l2.insert(6);
		l2.insert(4);
		
		l1.printList();
		l2.printList();
		
		l.head = l.addTwoNumbers(l1.head, l2.head);
		
		l.printList();
		
		l.head = l.addTwoNumbersII(l1.head, l2.head);
		
		l.printList();
		
		Lista lista = new Lista();
		lista.head = lista.mergeTwoLists(l1.head, l2.head);
		lista.printList();
		
		
		Lista lista1 = new Lista();
		Lista lista2 = new Lista();
		
		Nodo[] arrNodos = new Nodo[] {l.head,l1.head,l2.head};
		
		Lista listaArrNodos = new Lista();
		listaArrNodos.head = listaArrNodos.mergeKLists(arrNodos);
		listaArrNodos.printList();
		
		Lista lista3 = new Lista();
		lista3.insert(60);
		lista3.insert(50);
		lista3.insert(40);
		lista3.insert(30);
		lista3.insert(20);
		lista3.insert(10);
		
		lista3.printList();
		lista3.head = lista3.rotar(lista3.head, 4);
		lista3.printList();
		//lista3.head = lista3.rotar(l.head, 4);
		//lista3.printList();
		
		Lista lista4 = new Lista();
		lista4.insert(4);
		lista4.insert(3);
		lista4.insert(2);
		lista4.insert(1);
		
		lista4.head = lista4.swapPairs(lista4.head);
		lista4.printList();
		
		Lista lista5 = new Lista();
		lista5.insert(70);
		lista5.insert(60);
		lista5.insert(50);
		lista5.insert(40);
		lista5.insert(30);
		lista5.insert(20);
		lista5.insert(10);
		
		lista5.head = lista5.reverseBetween(lista5.head, 3, 6);
		lista5.printList();
		
		Lista lista6 = new Lista();
		lista6.insert(-4);
		lista6.insert(0);
		lista6.insert(2);
		lista6.insert(3);
		
		
		lista6.head = lista6.cycleList(lista6.head);
		lista6.printList();
	}
}
