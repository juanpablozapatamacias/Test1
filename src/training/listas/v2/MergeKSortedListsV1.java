package training.listas.v2;

public class MergeKSortedListsV1 {
	
	public static Nodo<Integer> merge(Nodo<Integer>[] lists){
		if(lists == null || lists.length == 0) return null;
		if(lists.length == 1) return lists[0];
		
		int n = lists.length -  1;
		
		while(n != 0) {
			int i=0, j=n;
			
			while(i < j) {
				lists[i] = sortedMerge(lists[i], lists[j]);
				
				i++;
				j--;
				
				if(i>=j) n = j;
			}
		}
		
		return lists[0];
	}

	private static Nodo<Integer> sortedMerge(Nodo<Integer> a, Nodo<Integer> b) {
		// TODO Auto-generated method stub
		if(a==null) return b;
		else if(b==null) return a;
		
		Nodo<Integer> result;
		
		if(a.getDato() <= b.getDato()) {
			result =a;
			result.setNext(sortedMerge(a.getNext(),b));
		}
		else {
			result = b;
			result.setNext(sortedMerge(a,b.getNext()));
		}
		
		return result;
		
		
	}

	public static void printlist(Nodo<Integer> head) {
		if(head == null) return;
		Nodo<Integer> aux = head;
		
		while(aux != null) {
			System.out.print(aux.getDato() + " > ");
			aux = aux.getNext();
		}
		
		System.out.println("NULL");
		System.out.println();
	}
	
	public static void main(String[] arg) {
		Nodo<Integer> res;
		
		Nodo<Integer> l1 = new Nodo<Integer>(2);
		l1.setNext(new Nodo<Integer>(4));
		l1.getNext().setNext(new Nodo<Integer>(6));
		
		Nodo<Integer> l2 = new Nodo<Integer>(1);
		l2.setNext(new Nodo<Integer>(3));
		l2.getNext().setNext(new Nodo<Integer>(5));
		l2.getNext().getNext().setNext(new Nodo<Integer>(7));
		
		Nodo<Integer> l3 = new Nodo<Integer>(8);
		l3.setNext(new Nodo<Integer>(9));
		l3.getNext().setNext(new Nodo<Integer>(10));
		l3.getNext().getNext().setNext(new Nodo<Integer>(11));
		
		printlist(l1);
		printlist(l2);
		printlist(l3);
		
		Nodo[] A = {l1,l2,l3};
		
		res = merge(A);
		
		printlist(res);
		
	}
	

}
