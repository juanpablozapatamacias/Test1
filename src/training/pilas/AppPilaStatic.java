package training.pilas;

import javax.swing.JOptionPane;

public class AppPilaStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc=0,ele,tam;
		
		try {
			tam = Integer.parseInt(JOptionPane.showInputDialog(null,
					"De que tamanio quieres la Pila?",
					"Solicitando el Tamanio de la Pila",
					JOptionPane.INFORMATION_MESSAGE));
			Pila pilita = new Pila(tam);
			do {
				opc = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Insertar un Elemento en la Pila\n"
						+ "2. Sacar un Elemento en la Pila\n"
						+ "3. Pila Vacia ?? \n"
						+ "4. Pila llena ??\n"
						+ "5. Elemento en la cima??\n"
						+ "6. Tamanio en la Pila\n"
						+ "7. Ordenamiento de elementos de la Pila\n"
						+ "8. Buscar Elemento de la Pila\n"
						+ "9. Salir","Opciones en la Pila",
						JOptionPane.QUESTION_MESSAGE));	
				switch(opc) {
					case 1:
						ele=Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el elemento a insertar",
								"Apilando",
								JOptionPane.QUESTION_MESSAGE));
						if(!pilita.estaLlena()) {
							pilita.empujar(ele);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta llena... ",
									"Pila Llena",JOptionPane.INFORMATION_MESSAGE);
						}
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
						if(pilita.estaLlena()) {
							JOptionPane.showMessageDialog(null, "La pila esta llena... ",
									"Pila Llena",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "La pila no esta llena... ",
									"Pila tiene espacio",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 5: 
						if(!pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "El elemento en la cima es: " + pilita.cima,
									"Cima de la Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 6: 
						if(!pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "El tamanio de la pila es: " + pilita.tamPila(),
									"Tamanio de la Pila",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 7: 
						if(!pilita.estaVacia()) {
							JOptionPane.showMessageDialog(null, "La pila esta ordenada",
									"La pila esta ordenada",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "La pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 8: 
						System.out.println();
						if(!pilita.estaVacia()) {
							pilita.mostrarElementos();
						}
						else {
							JOptionPane.showMessageDialog(null, "La Pila esta vacia... ",
									"Pila Vacia",JOptionPane.INFORMATION_MESSAGE);
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
			}while(opc != 9);
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
	}

}
