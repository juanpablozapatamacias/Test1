package training.pilas.implementation;

public class PilaClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pila pilita = new Pila(6);
		pilita.push(6);
		pilita.push(4);
		pilita.push(1);
		pilita.push(5);
		pilita.push(2);
		pilita.push(3);
		
		System.out.println("Tamanio de la pila despues de hacer push " + pilita.size());
		
		System.out.print("Sacar elementos de la pila: ");
		while(!pilita.isEmpty()) 
			System.out.print(pilita.pop() + " ");
		
		System.out.println("\nTamanio de la pila despues de sacar elementos " + pilita.size());

	}

}
