package training.pilas;

public class Pila {
	
	public int vectorPila[];
	public int cima;
	
	public Pila(int tam) {
		this.vectorPila=new int [tam];
		cima=-1;
	} 
	
	// Metodo push
	public void empujar(int dato) {
		cima++;
		vectorPila[cima]=dato;
	}
	
	// Metodo Pop
	public int sacar() {
		int fuera=vectorPila[cima];
		cima--;
		return fuera;
	}
	
	// Metodo para saber si la pila esta vacia
	public boolean estaVacia() {
		return cima==-1;
	}
	
	//Metodo para saber si la pila esta llena
	public boolean estaLlena() {
		return vectorPila.length - 1 == cima;
	}
	
	//Metodo para saber que metodo esta en la cima
	public int cimaPila() {
		return vectorPila[cima];
	}
	
	//Metodo para saber el tamano de la pila
	public int tamPila() {
		return vectorPila.length;
	}

	//Metodo para ordenar elementos de la pila 
	public void ordenarElementosPila() {
		for(int i=0;i<vectorPila.length;i++) {
			for(int j=i+1;j<=vectorPila.length-1;j++) {
				if(vectorPila[i] > vectorPila[j]) {
					int aux = vectorPila[i];
					vectorPila[i] = vectorPila[j];
					vectorPila[j] = aux;
				}
			}
		}
	}

	public void mostrarElementos() {
		// TODO Auto-generated method stub
		for(int i=0;i<vectorPila.length;i++) {
			System.out.println(vectorPila[i] + " ");
		}
	}
	
}
