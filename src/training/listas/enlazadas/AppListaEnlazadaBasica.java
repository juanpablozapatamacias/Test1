package training.listas.enlazadas;

public class AppListaEnlazadaBasica {
	

	public static void main(String[] args) {
	
		ListaEnlazada<Integer> lista = new ListaEnlazada<>(); 
		
		lista.agregarNodoAlFinal(3);
		lista.agregarNodoAlFinal(1);
		lista.agregarNodoAlFinal(9);
		lista.agregarNodoAlFinal(5);
		
		Nodo<Integer> n;
		
		n= lista.mergeSortLinkedList(lista.head);
	}
}
