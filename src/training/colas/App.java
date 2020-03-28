package training.colas;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		int opc =0, elemento =0;
		Cola colita = new Cola();
		
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Insertar un Elemento en la Cola\n"
						+ "2. Quitar un Elemento en la Cola\n"
						+ "3. Cola Vacia \n"
						+ "4. Elemento ubicado en la Cola\n"
						+ "5. Tam de la Cola\n"
						+ "6. Ordenamiento elementos de la Cola\n"
						+ "7. Mostrar Elementos de la Cola\n"
						+ "8. Buscar Elemento de la Cola\n"
						+ "9. Salir","Opciones en la Cola",
						JOptionPane.QUESTION_MESSAGE));
				switch(opc) {
					case 1: 
						System.out.println();
						elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a insertar",
								"Insertar en la cola",
								JOptionPane.QUESTION_MESSAGE));
						colita.insertar(elemento);
						break;
					case 2: 
						System.out.println();
						if(!colita.esVacia()) {
							JOptionPane.showMessageDialog(null, "Elemento Atendido " + colita.quitar(),
									"Quitando Elementos de la cola",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 3: 
						System.out.println();
						if(colita.esVacia()) {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La cola no esta vacia... ",
									"Cola No Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 4: 
						System.out.println();
						if(!colita.esVacia()) {
							JOptionPane.showMessageDialog(null, 
									"El elemento ubicado al inicio de la cola es " + colita.inicioCola(),
									"Inicio",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 5: 
						System.out.println();
						if(!colita.esVacia()) {
							JOptionPane.showMessageDialog(null, 
									"El tamano de la cola es  " + colita.tamCola(),
									"Tamanio de la cola",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 6:
						System.out.println();
						if(!colita.esVacia()) {
							colita.ordenarCola();
						}
						else {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 7:
						System.out.println();
						if(!colita.esVacia()) {
							colita.mostrarElementos();
						}
						else {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 8:
						System.out.println();
						elemento=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a buscar",
								"Buscar elemento en la cola",
								JOptionPane.QUESTION_MESSAGE));
						if(!colita.esVacia()) {
							colita.buscarElemento(elemento);
						}
						else {
							JOptionPane.showMessageDialog(null, "La cola esta vacia... ",
									"Cola Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 9: 
						JOptionPane.showMessageDialog(null,"Aplicacion Finalizada",
								"Fin", JOptionPane.INFORMATION_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opcion Incorrecta ...",
								"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						break;
				}
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
			}
		}while(opc != 9);
	}

}
