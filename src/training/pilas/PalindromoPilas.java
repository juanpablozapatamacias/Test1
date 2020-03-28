package training.pilas;

class StackOverflowException extends Exception{}
class StackUnderflowException extends Exception{}

class Pilas{
	private static final int TAM_PILA = Integer.MAX_VALUE;
	private int cima;
	private char[] listaPila;
	
	public Pilas() {
		this(TAM_PILA);
	}

	public Pilas(int tamPila) {
		// TODO Auto-generated constructor stub
		cima = -1;
		if(tamPila <= 0) listaPila = new char[TAM_PILA];
		else listaPila = new char[tamPila];
	}
	
	public boolean isEmpty() {
		return cima ==-1;
	}
	
	public boolean isFull() {
		return cima == TAM_PILA-1;
	}
	
	public void cleanStack() {
		cima = -1;
	}
	
	public void push(char elem) throws StackOverflowException{
		if(isFull()) throw new StackOverflowException();
		
		listaPila[++cima] = elem;
	}
	
	public char pop() throws StackUnderflowException{
		if(isEmpty()) throw new StackUnderflowException();
		
		char aux;
		aux = listaPila[cima--];
		
		return aux;
	}
	
	public char peek() {
		return listaPila[cima];
	}
	
}

public class PalindromoPilas {

	public static boolean isPalindromo(String str) throws StackOverflowException, StackUnderflowException {
		Pilas pila = new Pilas(str.length());
		String reverse = "";
		String temp = str.replaceAll("[^a-zA-Z0-9]", "");
		boolean band = false;
		
		for (int i=0;i<temp.length();) {
			pila.push(temp.charAt(i++));
		}
		
		while(!pila.isEmpty()) reverse += pila.pop();
		
		return temp.equals(reverse);
	}
	
	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		String s = "ho   ooH   oooh";
		System.out.println(isPalindromo(s) ? "Palindromo" : "No es Palindromo");
	}
}
