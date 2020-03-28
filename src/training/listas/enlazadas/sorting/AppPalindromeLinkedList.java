package training.listas.enlazadas.sorting;

public class AppPalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEnlazadaInt lista = new ListaEnlazadaInt();
		
		lista.insertAtEnd(1);
		lista.insertAtEnd(2);
		lista.insertAtEnd(2);
		lista.insertAtEnd(2);
		lista.insertAtEnd(2);
		lista.insertAtEnd(1);
		
		System.out.println(lista.isPalindrome(lista.head) ? "Palindrome" : "Not Palindrome");
	}

}
