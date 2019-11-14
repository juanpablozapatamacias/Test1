package itexico.training.arboles;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion=0;
		int elemento;
		int altura=0;
		String nombre;
		
		ArbolBinario arbol = new ArbolBinario();
		
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Agregar un Nodo\n"
						+ "2. Recorrer Arbol InOrden\n"
						+ "3. Recorrer Arbol PreOrden\n"
						+ "4. Recorrer Arbol PostOrden\n"
						+ "5. Buscar un Nodo\n"
						+ "6. Eliminar un Nodo\n"
						+ "7. Obtener la altura de un Arbol\n"
						+ "8. Validar arbol binario\n"
						+ "9. Salir \n"
						+ "Elige una Opcion ....","Arboles Binarios",
						JOptionPane.QUESTION_MESSAGE));
				switch(opcion) {
					case 1:
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Ingresa el numero del nodo...","Agregando Nodo",
								JOptionPane.QUESTION_MESSAGE));
						nombre = JOptionPane.showInputDialog(null,
								"Ingresa el nombre del Nodo...","Agregando Nodo",
								JOptionPane.QUESTION_MESSAGE);
						arbol.agregarNodo(elemento, nombre);
						break;
					case 2:
						System.out.println();
						if(!arbol.isEmpty()) {
							arbol.inOrden(arbol.raiz);
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 3:
						System.out.println();
						if(!arbol.isEmpty()) {
							arbol.preOrden(arbol.raiz);
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 4:
						System.out.println();
						if(!arbol.isEmpty()) {
							arbol.postOrden(arbol.raiz);
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 5:
						System.out.println();
						if(!arbol.isEmpty()) {
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
									"Ingresa el numero del nodo a buscar...","Buscando Nodo",
									JOptionPane.QUESTION_MESSAGE));
							
							if(arbol.busquedaNodo(elemento) == null) {
								JOptionPane.showMessageDialog(null,"El nodo no es encuentra en el arbol",
										"Nodo no encontrado", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								System.out.println("Nodo Encontrado!!!! Sus datos son: " + arbol.busquedaNodo(elemento));
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 6:
						System.out.println();
						if(!arbol.isEmpty()) {
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
									"Ingresa el numero del nodo a eliminar...","Eliminando Nodo",
									JOptionPane.QUESTION_MESSAGE));
							
							if(!arbol.eliminarNodo(elemento)) {
								JOptionPane.showMessageDialog(null,"El nodo no es encuentra en el arbol",
										"Nodo no encontrado", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								System.out.println("Nodo Eliminado!!!! ");
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 7:
						System.out.println();
						if(!arbol.isEmpty()) {
							altura = arbol.height(arbol.raiz);
							System.out.println("La altura del arbol es : " + altura);
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio, no se puede calcular la altura ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						break;
					case 8:
						System.out.println();
						if(!arbol.isEmpty()) {
							JOptionPane.showMessageDialog(null,"El resultado de la validacion del arbol es "
									+ arbol.isArbolBinarioValido() +" ...",
									"Validacion", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null,"El arbol esta vacio, no se puede validar ...",
									"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						}
						
					case 9: 
						JOptionPane.showMessageDialog(null,"Aplicacion Finalizada",
								"Fin", JOptionPane.INFORMATION_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opcion Incorrecta ...",
								"Cuidado!!!", JOptionPane.INFORMATION_MESSAGE);
						
				}	
			}
			catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null,  "Error " + n.getMessage());
			}
			
		}while(opcion!=9);
	}

}
