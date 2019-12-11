package itexico.training.pilasdinamicas;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] arg) {
		int opc = 0, ele=0;
		Pila pilita = new Pila();
		
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Insertar un Elemento en la Pila\n"
						+ "2. Sacar un Elemento en la Pila\n"
						+ "3. Pila Vacia ?? \n"
						+ "4. Elemento en la cima??\n"
						+ "5. Tamanio en la Pila\n"
						+ "6. Limpiar la Pila\n"
						+ "7. Mostrar los elementos de la Pila\n"
						+ "8. Ordenamiento de elementos de la Pila\n"
						+ "9. Buscar Elemento de la Pila\n"
						+ "10. Invertir la lista de la Pila\n"
						+ "11. Salir","Opciones en la Pila",
						JOptionPane.QUESTION_MESSAGE));	
				switch(opc) {
					case 1:
						ele=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a insertar",
								"Apilando",
								JOptionPane.QUESTION_MESSAGE));
						pilita.empujar(ele);
						break;
					case 2: 
						if(!pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "Elemento Obtenido es " + pilita.sacar(),
									"Sacando Elementos de la pila",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 3:
						if(pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La pila no esta vacia... ",
									"Pila No Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 4: 
						if(!pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "El elemento en la cima es: " + pilita.cima(),
									"Cima de la Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 5: 
						if(!pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "El tamanio de la pila es: " + pilita.tamPila(),
									"Tamanio de la Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 6: 
						if(!pilita.estaVacia()) {
							pilita.limpiar();
							JOptionPane.showMessageDialog(null, "La pila se ha vaciado " ,
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 7: 
						System.out.println();
						if(!pilita.estaVacia()) {
							pilita.mostrarElementos();
						}
						else {
							JOptionPane.showMessageDialog(null, "La Pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 8:
						if(!pilita.estaVacia()) {
							pilita.ordenarPila();
							JOptionPane.showMessageDialog(null, "La pila fue ordenada..." ,
									"La pila esta ordenada",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break; 
					case 9:
						ele=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a buscar",
								"Buscar elemento en la cola",
								JOptionPane.QUESTION_MESSAGE));
						if(!pilita.estaVacia()) {
							pilita.buscarElemento(ele);
							JOptionPane.showMessageDialog(null, "Elemento encontrado" ,
									"La pila esta ordenada",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Elemento ila",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 10: 
						if(!pilita.estaVacia()) {
							pilita.invertirPila();
							JOptionPane.showMessageDialog(null, "Lista de la Pila invertida",
									"Invertir Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Elemento Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 11: 
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
		}while(opc!=11);
		
	}
}
