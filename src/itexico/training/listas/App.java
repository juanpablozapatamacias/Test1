package itexico.training.listas;

public class App {

	public static void main(String[] args) {
		Nodo head = null;
		Lista<Integer> lista = new Lista<>();
		
		lista.insert(5);
		lista.insert(6);
		lista.insert(7);
		lista.insert(2);
		lista.insert(1);
		
		
		System.out.println("Imprime los elementos de una lista");
		lista.printlist();
		
		System.out.println();
		Nodo n1 = lista.removeNodeAnyPostion(lista.head, 3);
		lista.printlist();
		
		lista.insert(9);
		lista.insert(4);
		
		System.out.println();
		lista.printlist();
		
		System.out.println();
		System.out.println("Imprime los elementos en reverse mode");
		lista.reverse();
		lista.printlist();
		System.out.println();
		
		
		
		Nodo n = lista.head;
		lista.head.getSiguiente().getSiguiente().getSiguiente().setSiguiente(lista.head);
		//n.getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(lista.head);
		
		if(lista.cycleInList(lista.head)) System.out.println("Ciclo en lista");
		else System.out.println("No hay ciclo");
		
		
	}

}
