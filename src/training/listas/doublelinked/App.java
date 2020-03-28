package training.listas.doublelinked;

import javax.swing.JOptionPane;

import training.listas.doublelinked.NodoDoble;;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaDoble listita = new ListaDoble();
		NodoDoble n;
		
		int opc=0,ele=0;
		
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Agregar un nodo al inicio\n"
						+ "2. Agregar un nodo al final\n"
						+ "3. Mostrar un nodo de inicio a fin \n"
						+ "4. Mostrar un nodo de fin a inicio\n"
						+ "5. Aplicar reversa a la lista\n"
						+ "6. Salir","Opciones en la Pila",
						JOptionPane.QUESTION_MESSAGE));	
				switch(opc) {
					case 1:
						ele=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a insertar al inicio",
								"Ingresar elemento al innicio",
								JOptionPane.QUESTION_MESSAGE));
						listita.agregarNodoInicio(ele);
						break;
					case 2:
						ele=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a insertar al final",
								"Ingresar elemento al final",
								JOptionPane.QUESTION_MESSAGE));
						listita.agregarNodoFinal(ele);
						break;
					case 3:
						if(!listita.estaVacia())
							listita.mostrarListaInicioFin();
						else 
							JOptionPane.showMessageDialog(null, "La lista esta vacia... ",
									"Lista Vacia",JOptionPane.INFORMATION_MESSAGE);
						break;
					case 4: 
						if(!listita.estaVacia())
							listita.mostrarListaFinInicio();
						else
							JOptionPane.showMessageDialog(null, "La lista esta vacia... ",
									"Lista Vacia",JOptionPane.INFORMATION_MESSAGE);
						break;
					case 5: 
						if(!listita.estaVacia()) {
							n = listita.reverse(listita.getInicio());
							JOptionPane.showMessageDialog(null, "La lista con reversa esta aplicada... ",
									"Lista Reversa",JOptionPane.INFORMATION_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "La lista esta vacia... ",
									"Lista Vacia",JOptionPane.INFORMATION_MESSAGE);
						break;
					case 6: 
						JOptionPane.showMessageDialog(null,"Aplicacion Finalizada",
								"Fin", JOptionPane.INFORMATION_MESSAGE);
						break;
					default: 
						JOptionPane.showMessageDialog(null,"Opcion Incorrecta ...",
								"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						break;
				}
			}
			catch(NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "Error " + ne.getMessage());
			}
		}while(opc != 6);
	}

}
