package itexico.training.arboles;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {

	NodoArbol raiz;
	public ArbolBinario() {
		raiz = null;
	}
	
	//Metodo para insertar un nodo en el arbol
	
	public void agregarNodo(int d, String nom) {
		NodoArbol nuevo = new NodoArbol(d,nom);
		NodoArbol auxiliar;
		NodoArbol padre;
		
		if (raiz == null) {
			raiz = nuevo;
		}
		else {
			auxiliar = raiz;
			
			while(true) {
				padre = auxiliar;
				if(d < auxiliar.getDato()) {
					auxiliar = auxiliar.getIzq();
					if(auxiliar==null) {
						padre.setIzq(nuevo);
						return;
					}
				}
				else {
					auxiliar=auxiliar.getDer();
					if(auxiliar==null) {
						padre.setDer(nuevo);
						return;
					}
				}
			}
		}
	}
	
	// Metodo para saber cuando el arbol esta vacio
	
	public boolean isEmpty() {
		return raiz == null;
	}
	
	// Metodo para recorrer el arbol InOrden
	
	public void inOrden(NodoArbol r) {
		if(r!=null) {
			inOrden(r.getIzq());
			System.out.print(r.getDato() + " ");
			inOrden(r.getDer());
		}
	}
	
	// Metodo para recorrer el arbol PreOrden
	
	public void preOrden(NodoArbol r) {
		if(r!=null) {
			System.out.print(r.getDato() + " ");
			preOrden(r.getIzq());
			preOrden(r.getDer());
		}
	}
	
	// Metodo para recorrer el arbol PostOrden
	public void postOrden(NodoArbol r) {
		if(r!=null) {
			postOrden(r.getIzq());
			postOrden(r.getDer());
			System.out.print(r.getDato() + " ");
		}
	}
	
	// Metodo para busqueda de nodo en el arbol
	public NodoArbol busquedaNodo(int d) {
		NodoArbol aux = raiz;
		
		while(aux.getDato() != d) {
			if(d < aux.getDato()) {
				aux = aux.getIzq();
			}
			else {
				aux = aux.getDer();
			}
			
			if (aux == null) return null;
		}
		return aux;
	}
	
	// Metodo para eliminar un Nodo de un arbol
	public boolean eliminarNodo(int d) {
		NodoArbol aux = raiz;
		NodoArbol padre = raiz;
		boolean esIzq = false;
		
		while(aux.getDato() != d) {
			padre = aux;
			if(d < aux.getDato()) {
				esIzq = true;
				aux = aux.getIzq();
			}
			else {
				esIzq = false;
				aux = aux.getDer();
			}
			if (aux == null) return false;
		}
		
		if(aux.getIzq() == null && aux.getDer() == null) {
			if(aux == raiz) raiz = null;
			else if(esIzq) padre.setIzq(null);
			else padre.setDer(null);
		}
		
		else if(aux.getDer() == null) {
			if(aux == raiz) raiz = aux.getIzq();
			else if(esIzq) padre.setIzq(aux.getIzq());
			else padre.setDer(aux.getIzq());
		}
		
		else if(aux.getIzq() == null) {
			if(aux == raiz) raiz = aux.getDer();
			else if(esIzq) padre.setIzq(aux.getDer());
			else padre.setDer(aux.getIzq());
		}
		
		else{
			NodoArbol reemplazo = obtenerNodoReemplazo(aux);
			if(aux == raiz) raiz = reemplazo;
			else if(esIzq) padre.setIzq(reemplazo);
			else padre.setDer(reemplazo);
			
			reemplazo.setIzq(aux.getIzq());
		}	
		return true;
	}

	//Metodo para obtener el nodo reemplazo
	public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReem) {
		NodoArbol reemplazarPadre = nodoReem;
		NodoArbol reemplazo = nodoReem;
		NodoArbol aux = nodoReem.getDer();
		
		while(aux != null) {
			reemplazarPadre = reemplazo;
			reemplazo = aux;
			aux = aux.getIzq();
		}
		
		if(reemplazo != nodoReem.getDer()) {
			reemplazarPadre.setIzq(reemplazo.getDer());
			reemplazo.setDer(nodoReem.getDer());
		}
		System.out.println("El nodo reemplazo es " + reemplazo);
		return reemplazo;
	}
	
	//Metodo para obtener la altura (height) del arbol
	public int height(NodoArbol nodo) {
		if (nodo == null) return 0;
		
		return 1 + Math.max(height(nodo.getIzq()), height(nodo.getDer()));
	}
	
	// Metodo para invertir el arbol
	public NodoArbol invertTreeRecursive(NodoArbol nodo) {
		if(nodo != null) {
			NodoArbol izq = nodo.getIzq();
			NodoArbol der = nodo.getDer();
			nodo.setIzq(der);
			nodo.setDer(izq);
		}
		return nodo;
	}
	
	//Metodo para invertir el arbol por medio de Queue lib
	public NodoArbol invertTreeQueue(NodoArbol nodo) {
		if(nodo != null) {
			Queue<NodoArbol> queue = new LinkedList<NodoArbol>();
			queue.add(nodo);
			while(!queue.isEmpty()) {
				NodoArbol current = queue.poll();
				NodoArbol temp = current.getIzq();
				current.setIzq(current.getDer());
				current.setDer(temp);
				if(current.getIzq() != null) queue.add(current.getIzq());
				if(current.getDer() != null) queue.add(current.getDer());
			}
		}
		return nodo;
	}
	
	// Validar arbol binario
	public boolean isArbolBinarioValidoUtil(NodoArbol nodo, int min, int max) {
		if(nodo == null) return true;
		
		if(nodo.getDato() < min && nodo.getDato() > max) return false;
		
		return (isArbolBinarioValidoUtil(nodo.getDer(),min, nodo.getDato()-1) 
				&& isArbolBinarioValidoUtil(nodo.getIzq(), nodo.getDato()+1, max));
	}
	
	public boolean isArbolBinarioValido() {
		return isArbolBinarioValidoUtil(raiz,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
}
