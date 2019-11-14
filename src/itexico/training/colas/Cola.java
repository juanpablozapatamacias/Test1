package itexico.training.colas;

public class Cola {

	NodoCola inicio,fin;
	int tam;
	
	public Cola() {
		inicio=fin=null;
		tam=0;
	}
	
	public boolean esVacia() {
		return inicio==null;
	}
	
	public void insertar(int ele) {
		NodoCola nuevo = new NodoCola(ele);
		if(esVacia()) inicio =  nuevo;
		else fin.setSiguiente(nuevo);
		
		fin = nuevo;
		tam++;
	}
	
	public int quitar() {
		int aux = inicio.getDato();
		inicio = inicio.getSiguiente();
		tam --;
		return aux;
	}
	
	public int inicioCola() {
		return inicio.getDato();
	}
	
	public int tamCola() {
		return tam;
	}
	
	public void ordenarCola() {
		int[] arr = new int [tamCola()];
		int c=0;
		int aux;
		
		while (true) {
			arr[c] = quitar();
			c++;
			if(inicio == null) break;
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
			insertar(arr[i]);
		
		System.out.println("Cola ordenada");
	}
	
	public void mostrarElementos() {
		NodoCola col = inicio;
		while(col != null) {
			System.out.print(col.getDato() + " ");
			col = col.getSiguiente();
		}
	}
	
	public void buscarElemento(int ele) {
		NodoCola aux = inicio;
		NodoCola lug = null;
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
}
