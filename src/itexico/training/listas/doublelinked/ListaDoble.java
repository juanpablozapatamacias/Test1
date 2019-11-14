package itexico.training.listas.doublelinked;

public class ListaDoble {
	private NodoDoble inicio = null;
	private NodoDoble fin = null;
	
	public ListaDoble() {
		inicio=fin=null;
	}
	
	//Metodo para saber si la lista esta vacia
	public  boolean estaVacia() {
		return inicio==null;
	}
	
	//Metodo para agregar nodos al final
	public void agregarNodoFinal(int ele) {
		if(!estaVacia()) {
			this.setFin(new NodoDoble(ele,null,this.getFin()));
			this.getFin().getAnterior().setSiguiente(this.getFin());
		}else {
			inicio = fin = new NodoDoble(ele);
			//this.setInicio(new NodoDoble(ele));
			//this.setFin(new NodoDoble(ele));
		}
	}
	
	//Metodo para agregar nodos al inicio
	public void agregarNodoInicio(int ele) {
		if(!estaVacia()) {
			this.setInicio(new NodoDoble(ele,this.getInicio(),null));
			this.getInicio().getSiguiente().setAnterior(this.getInicio());
		}else {
			inicio = fin = new NodoDoble(ele);
			//this.setInicio(new NodoDoble(ele));
			//this.setFin(new NodoDoble(ele));
		}
	}
	
	// Metodo para mostrar la lista de inicio a fin
	public void mostrarListaInicioFin() {
		if(!estaVacia()) {
			String datos = "<->";
			NodoDoble aux = this.getInicio();
			while(aux!=null) {
				datos += "["+aux.getDato()+"]<->";
				aux = aux.getSiguiente();
			}
			
			System.out.println("Mostrando la lista de datos de inicio a fin " + datos);
		}
	}
	
	// Metodo para mostrar lista de fin a inicio
	public void mostrarListaFinInicio() {
		if(!estaVacia()) {
			String datos = "<->";
			NodoDoble aux = this.getFin();
			while(aux!=null) {
				datos += "["+aux.getDato()+"]<->";
				aux = aux.getAnterior();
			}
			
			System.out.println("Mostrando la lista de datos de fin a inicio " + datos);
		}
	}
	
	// Metodo para mostrar el reverse de una lista doblemente enlazada
	public NodoDoble reverse(NodoDoble n) {
		if(n == null)
			return null;
		
		NodoDoble aux = n.getSiguiente();
		n.setSiguiente(n.getAnterior());
		n.setAnterior(aux);
		
		if(n.getSiguiente() == null) return n;
		
		return reverse(n.getSiguiente());
	}
	

	public NodoDoble getInicio() {
		return inicio;
	}

	public void setInicio(NodoDoble inicio) {
		this.inicio = inicio;
	}

	public NodoDoble getFin() {
		return fin;
	}

	public void setFin(NodoDoble fin) {
		this.fin = fin;
	}
	

}
