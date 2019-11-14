package itexico.training.listas.palindromo;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {1,2,3,3,2,1};
		Lista<Integer> lista = new Lista<Integer>();
		
		for (int i=0; i<arr.length;i++) {
			lista.insert(arr[i]);
			lista.printList(lista.head);
			if(lista.isPalindromeRev(lista.head) != false) {
				System.out.println("Palindrome");
				System.out.println();
			}
			else {
				System.out.println("Not Palindrome");
				System.out.println();
			}
		}
			
		
		
	}

}
