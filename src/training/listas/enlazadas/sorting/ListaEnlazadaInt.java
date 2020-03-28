package training.listas.enlazadas.sorting;

public class ListaEnlazadaInt {
	
	Nodo head = null;
	int tam=0;
	
	public ListaEnlazadaInt() {}
	
	/**
	 * Method that return a boolean if linked list is empty
	 * 
	 * @return true is this empty
	 * 
	 * */
	public boolean esVacia() {
		return head == null;
	}
	
	/**
	 * Method that returns the linked list size
	 * 
	 * @return tam if list contains any node(s)
	 * 
	 * */
	public int getSize() {
		return tam;
	}
	
	/**
	 * Method that adds a node at the tail of the list
	 * 
	 * @param dato to add any value to the new node
	 * 
	 * */
	public void insertAtEnd(int dato) {
		// Define a new node
		Nodo nodo = new Nodo(dato);
		Nodo aux;
		
		// If list is empty
		if(esVacia()) head = nodo;
		else {
			aux = head;
			
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			
			aux.setNext(nodo);
		} 
		tam++;
	}
	
	/**
	 * Method that adds a node at the beginning of the list
	 * 
	 * @param dato to add any value to the new node
	 * 
	 * */
	public void insertAtBeginning(int dato) {
		// Define a new node
		Nodo nodo = new Nodo(dato);
		
		// If list is empty
		if(esVacia()) head = nodo;
		else {
			// adding new values to the list
			nodo.setNext(head);
			head = nodo;
		}
		tam++;
	}
	
	/**
	 * Method that allow to insert a node with a specific position
	 * 
	 * @param position to traverse the list 
	 * @param dato to add any value in the new node
	 * 
	 * */
	public void insertByPosition(int position, int dato) {
		Nodo nodo = new Nodo(dato);
		Nodo aux;
		Nodo next;
		
		// Verify if the position added is located at the range 0 - position
		if(position>=0 && position<=tam) {
			// verify if the node will be inserted at beginning of the list
			if (position == 0) {
				nodo.setNext(head);
				head = nodo;
			}
			else {
				// Node is inserted at the end of list
				if(position ==  tam) {
					aux = head;
					
					//Iterate the list to the last node
					while (aux.getNext()!=null) aux = aux.getNext();
					
					// add the new node at the end
					aux.setNext(nodo);
				}
				else {
					// Node aux saves temporally the head
					aux = head;
					
					// Iterates the node until arrive to the position
					for (int i=0;i<(position-1);i++) aux = aux.getNext();
					
					//new node to the position to insert the new node
					next = aux.getNext();
					
					// Inserts new node to indicated position
					aux.setNext(nodo);
					
					// joins the node to the rest of list
					nodo.setNext(next);
				}
			}
		}
		
		tam++;
	}
	
	/**
	 * Method that prints the node elements inserted in the list
	 * 
	 * */
	public void printlist() {
		Nodo aux = head;
		while (aux != null) {
			System.out.print(aux.getDato() + " ");
			aux = aux.getNext();
		} 
		System.out.println();
	}
	
	/**
	 * Method that remove nodes in an specific position
	 * 
	 * */
	public void removeAtPosition(int position) {
		if(head == null) return;
		
		//Verifies if position entered belows to the range and find the list elements
		
		Nodo aux = head;
		Nodo siguiente;
		
		// Remove node at first position or at beginning, even when position is 0
		if (position==0) {
			head = aux.getNext();
			return;
		}
		else {
			for(int i=0;i<(position-1);i++) {
				aux = aux.getNext();
			}
			siguiente = aux.getNext();
			aux.setNext(siguiente.getNext());
		}
		tam--;
	}
	
	/**
	 * Method that counts a frequent element presented in the list
	 * 
	 * @param dato
	 * 
	 * */
	public int count(Nodo nodo, int dato) {
		if(nodo == null) return 0;
		
		Nodo aux = nodo;
		int frequency = count(aux.getNext(),dato);
		
		if(aux.getDato() == dato) return 1+frequency;
		
		return frequency;
		
	}
	
	/**
	 * Method that sort the list elements using merge sort algorithm
	 * 
	 * @param nodo
	 * 
	 * **/
	public Nodo mergeSortLinkList(Nodo startNodo) {
		Nodo middle;
		Nodo nextOfMiddle;
		Nodo left;
		Nodo right;
		Nodo sortedList;
		
		if(startNodo == null || startNodo.getNext() == null) return startNodo;
		
		middle = getMiddle(startNodo);
		nextOfMiddle = middle.getNext();
		middle.setNext(null);
		
		left = mergeSortLinkList(startNodo);
		right = mergeSortLinkList(nextOfMiddle);
		
		sortedList = mergeTwoListRecursive(left,right);
		
		return sortedList;
	}

	/**
	 * 
	 * Method that merge all the elements after do the merge in the divided list
	 * 
	 * @param left to get the list from 0 to middle
	 * @param right to get the list from middle + 1 to end
	 * 
	 * */
	private Nodo mergeTwoListRecursive(Nodo left, Nodo right) {
		// TODO Auto-generated method stub
		if(left==null) return right;
		if(right==null) return left;
		
		Nodo temp = null;
		
		if(left.getDato()<right.getDato()) {
			temp = left;
			temp.setNext(mergeTwoListRecursive(left.getNext(),right));
		}
		else {
			temp = right;
			temp.setNext(mergeTwoListRecursive(left,right.getNext()));
		}
		
		return temp;
	}

	/**
	 * Method that get the middle of the linkedList that allows to execute the merge sort algorithm
	 * 
	 * @param nodo
	 * 
	 * */
	private Nodo getMiddle(Nodo startNodo) {
		Nodo ptr1;
		Nodo ptr2;
		
		if(startNodo == null) return startNodo;
		
		ptr1 = startNodo;
		ptr2 = startNodo;
		
		while(ptr2 != null && ptr2.getNext()!=null && ptr2.getNext().getNext()!=null) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext().getNext();
		}
		
		return ptr1;
	}
	
	/**
	 * Method that removes the duplicated elements
	 * 
	 * */
	public void removeDuplicates() {
		Nodo curr = head;
		Nodo temp;
		
		while(curr != null) {
			temp = curr;
			while(temp!=null && temp.getDato() == curr.getDato()) {
				temp = temp.getNext();
			}
			
			curr.setNext(temp);
			curr = curr.getNext();
		}
	}
	
	/**
	 * 
	 * Method that find the kth to last element, using iteration
	 * 
	 * @param nodo
	 * @param n
	 * 
	 */
	public int kthByIteration(Nodo nodo, int n) {
		if(nodo == null) return 0;
		
		Nodo curr = head;
		Nodo sec = head;
		int val;
		
		while (n > 0) {
			curr = curr.getNext();
			n--;
		}
		
		while(curr != null) {
			curr = curr.getNext();
			sec = sec.getNext();
		}
		
		val = sec.getDato();
		return val;
	}
	
	/**
	 * 
	 * Method that find the kth to last element, using recursion
	 *
	 * @param nodo
	 * @param n
	 *
	 */
	public int kthByRecursion(Nodo nodo, int n) {
		if(nodo == null) return 0;
		
		int val = kthByRecursion(nodo.getNext(),n) + 1;
		
		if(val == n) System.out.println(nodo.getDato());
		
		return val;
	}
	
	/***
	 * 
	 * Method that removes a node in the middle
	 * 
	 * @param Nodo
	 * @return Nodo
	 * 
	 * */
	 public Nodo removeMiddleNode(Nodo nodo) {
		 
		 if(nodo == null) return null;
		 if(nodo.getNext() == null) return null;
		 
		 Nodo slow_ptr = head;
		 Nodo fast_ptr = head;
		 Nodo prev = null;
		 
		 while(fast_ptr != null && fast_ptr.getNext() !=null) {
			 fast_ptr = fast_ptr.getNext().getNext();
			 prev = slow_ptr;
			 slow_ptr = slow_ptr.getNext();
		 }
		 
		 prev.setNext(slow_ptr.getNext());
		 
		 return nodo;
	 }
	 
	 /**
	  * 
	  * Method that removes a node in the middle, by returning a boolean
	  * 
	  * @param nodo
	  * @return boolean
	  * */
	 public boolean removeMidNode(Nodo nodo) {
		 if(nodo == null || nodo.getNext() == null) return false;
		 
		 Nodo nextNodo = nodo.getNext();
		 nodo.setDato(nextNodo.getDato());
		 nodo.setNext(nextNodo.getNext());
		 
		 return true;
	 }
	 
	 /**
	  * 
	  * Method that does the partition in a list
	  * 
	  * @param nodo
	  * @return nodo
	  * 
	  * **/
	 public Nodo partition(Nodo nodo, int x) {
		 if (nodo == null) return null;
		 
		 Nodo fakehead1 = new Nodo(0);
		 Nodo fakehead2 = new Nodo(0);
		 
		 fakehead1.setNext(nodo);
		 
		 Nodo p = nodo;
		 Nodo prev = fakehead1;
		 Nodo p2 = fakehead2;
		 
		 while(p != null) {
			 if(p.getDato() < x) {
				 p = p.getNext();
				 prev = prev.getNext();
			 }
			 else {
				 p2.setNext(p);
				 prev.setNext(p.getNext());
				 
				 p = prev.getNext();
				 p2 = p2.getNext();
			 }
		 }
		 
		 p2.setNext(null);
		 prev.setNext(fakehead2.getNext());
		 
		 return fakehead1.getNext();
	 }
	 
	 /**
	  *
	  * Method that allows the sum of 2 numbers, represented by nodes
	  * 
	  * @param n1
	  * @param n2
	  * @return nodo with the sum of the numbers
	  * 
	  */
	 public Nodo sumLists(Nodo n1, Nodo n2) {
		 Nodo dummy = new Nodo(0);
		 Nodo p = n1;
		 Nodo q = n2;
		 Nodo curr = dummy;
		 
		 int carry = 0;
		 int x,y, sum;
		 
		 while(p!=null || q!=null) {
			 x = (p!=null) ? p.getDato() : 0;
			 y = (q!=null) ? q.getDato() : 0;
			 
			 sum = x+y+carry;
			 carry = sum / 10;
			 curr.setNext(new Nodo(sum % 10));
			 curr = curr.getNext();
			 
			 if(p != null) p = p.getNext();
			 if(q != null) q = q.getNext();
		 }
		 
		 if (carry > 0) curr.setNext(new Nodo(carry));
		 
		 return dummy.getNext();
	 }
	 
	 /**
	  * 
	  * Method that finds the middle element of the list
	  * 
	  * @param nodo
	  * @return nodo with the middle element
	  * 
	  * */
	 public Nodo findMiddleNode(Nodo nodo) {
		 Nodo slow_ptr, fast_ptr;
		 slow_ptr = nodo;
		 fast_ptr = nodo;
		 
		 while(fast_ptr != null && fast_ptr.getNext() != null) {
			 fast_ptr = fast_ptr.getNext().getNext();
			 slow_ptr = slow_ptr.getNext();
		 }
		 return slow_ptr;
	 }
	 
	 /**
	  * 
	  * Method that deletes a node in the linked list, except the tail
	  * 
	  * no param
	  *  
	  * **/
	 public void deleteNode(Nodo nodo) {
		 nodo.setDato(nodo.getNext().getDato());
		 nodo.setNext(nodo.getNext().getNext());
	 }
	 
	 /**
	  * 
	  * Method that prints the linked list contains with a node parameterized
	  * 
	  * @param nodo
	  * 
	  * **/
	 public void printlist(Nodo nodo) {
		 Nodo aux = nodo;
		 
		 while(aux != null) {
			 System.out.print(aux.getDato() + " ");
			 aux = aux.getNext();
		 }
	 }
	 
	 /**
	  * 
	  * Method that looks for a palindrome in the linked list
	  * @param nodo
	  * @return boolean to validate if this is a palindrome or not
	  * 
	  * **/
	 public boolean isPalindrome(Nodo nodo) {
		 if(nodo == null) return false;
		 
		 Nodo p = nodo;
		 Nodo prev = new Nodo(nodo.getDato());
		 Nodo temp;
		 Nodo p1,p2;
		 
		 while(p.getNext() !=null) {
			 temp = new Nodo(p.getNext().getDato());
			 temp.setNext(prev);
			 prev = temp;
			 p = p.getNext();
		 }
		 
		 p1 = nodo;
		 p2 = prev;
		 
		 while (p1!=null) {
			 if(p1.getDato() != p2.getDato()) return false;
			 
			 p1 = p2.getNext();
			 p2 = p2.getNext();
		 }
		 return true;
	 }
	 
	 /**
	  * 
	  * Method that reverses a linked list
	  * @param nodo
	  * @return nodo that displays reversed linked list
	  * 
	  * **/
	 public Nodo reverse(Nodo nodo) {
		 Nodo prev = null;
		 Nodo next = null;
		 Nodo curr = nodo;
		 
		 while(curr!=null) {
			 next = curr.getNext();
			 curr.setNext(prev);
			 prev = curr;
			 curr = next;
		 }
		 nodo = prev;
		 return nodo;
	 } 
	
}
