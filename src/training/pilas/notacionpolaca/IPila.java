package training.pilas.notacionpolaca;

public interface IPila {

	public void push(Object o);
	public Object pop();
	public Object top();
	public int longitud();
	public boolean esVacia();
	public void imprimir();
	
}
