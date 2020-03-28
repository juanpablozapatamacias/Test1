package training.pilasdinamicas;

public class Pila {
	private NodoPila cima;
	int tam;
	
	public Pila() {
		this.cima=null;
		this.tam=0;
	}
	
	//Metodo para saber cuando la pila es vacia
	public boolean estaVacia() {
		return cima == null;
	}
	
	// Metodo para hacer push un elemento a la pila
	public void empujar(int e) {
		NodoPila nuevo = new NodoPila(e);
		nuevo.setSiguiente(cima);
		cima = nuevo;
		tam++;
	}
		
	//Metodo para hacer pop un lemento en la pila
	public int sacar() {
		int aux = cima.getDato();
		cima = cima.getSiguiente();
		tam--;
		return aux;
	}
	
	//Metodo para saber el elemento que esta en la cima de la pila
	public int cima() {
		return cima.getDato();
	}
	
	// Metodo para saber el tamanio de la pila
	public int tamPila() {
		return tam;
	}
	
	// Metodo para vaciar la pila
	public void limpiar() {
		while(!this.estaVacia()) {
			this.sacar();
		}
	}
	
	//Metodo para mostrar elementos
	public void mostrarElementos() {
		NodoPila aux = cima;
		while(aux != null) {
			System.out.print(aux.getDato() + " ");
			aux = aux.getSiguiente();
		}
	}
	
	// Metodo para ordenar los elementos de la pila
	public void ordenarPila() {
		int[] arr = new int [tamPila()];
		int c=0;
		int aux;
		
		while (true) {
			arr[c] = sacar();
			c++;
			if(cima == null) break;
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<=arr.length-1;j++) {
				if(arr[i] > arr[j]) {
					aux = arr[i];
					arr[i] = arr[j];
					arr[j] = aux;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
			empujar(arr[i]);
		
		System.out.println("Pila ordenada");
	}

	// Metodo para buscar elementos en la pila
	public void buscarElemento(int ele) {
		// TODO Auto-generated method stub
		NodoPila aux = cima;
		NodoPila lug = null;
		boolean band = false;
		
		while(aux != null) {
			if(aux.getDato() == ele) {
				band=true;
				lug = aux;
				break;
			}
			else {
				aux = aux.getSiguiente();
			}
		}
		
		if(band && lug !=null) 
			System.out.println("El elemento " +lug.getDato()+ " se encuentra en la lista");
		else {
			lug=null;
			System.out.println("El elemento " +ele+ " no se encuentra en la lista");
		}
	}
	
	// Metodo para invertir la lista de la pila
	public void invertirPila() {
		NodoPila prev = null;
		NodoPila next = null;
		NodoPila curr = cima;
		
		while(curr != null) {
			next = curr.getSiguiente();
			curr.setSiguiente(prev);
			prev = curr;
			curr = next;
		}
		
		while(prev != null) {
			System.out.print(prev.getDato() + " ");
			prev = prev.getSiguiente();
		}
	}
	
}
