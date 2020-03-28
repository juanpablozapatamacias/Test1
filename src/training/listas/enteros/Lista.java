package training.listas.enteros;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.Comparator;

import training.listas.enteros.Nodo;
import training.utilities.Common;

public class Lista {
	Nodo head;
	
	public void insert(int dato) {
		Nodo new_node = new Nodo(dato);
		new_node.setSiguiente(this.head);
		head = new_node;
	}
	
	public void insertNthPosition(int dato, int position) {
		Nodo nodo = new Nodo(dato);
		if(position == 0) {
			nodo.setSiguiente(this.head);
			this.head = nodo;
		}
		else {
			Nodo aux = this.head;
			while(--position > 0)
				aux = aux.getSiguiente();
			
			nodo.setSiguiente(aux.getSiguiente());
			aux.setSiguiente(nodo);
		}
	}
	
	public void insertToTheLast(int dato) {
		Nodo node = new Nodo(dato);
		
		if(head == null) head =  node;
		else {
			Nodo temp =  head;
			while(temp.getSiguiente() != null) {
				temp = temp.getSiguiente();
			}
			temp.setSiguiente(node);
		}
	}
	
	public Nodo revKGroup(Nodo head, int k) {
		if(head == null || k==1) return head;
		
		Nodo fake = new Nodo(0);
		fake.setSiguiente(head);
		
		Nodo prev = fake;
		int i = 0;
		
		Nodo p = head;
		
		while(p!=null) {
			i++;
			if(i%k==0) {
				prev = this.reverse(prev, p.getSiguiente());
				p = prev.getSiguiente();
			}
			else {
				p = p.getSiguiente();
			}
		}
		
		return fake.getSiguiente();
	}
	
	public Nodo reverseKGroup(Nodo head, int k) {
		Nodo curr = head;
		Nodo next = null;
		Nodo prev = null;
		
		int count = 0;
		
		while (count < k && curr != null) {
			next = curr.getSiguiente();
			curr.setSiguiente(prev);
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) 
			head.setSiguiente(reverseKGroup(next,k));
		
		return prev.getSiguiente();
	}
	
	public Nodo reverse(Nodo prev, Nodo next) {
		Nodo last = prev.getSiguiente();
		Nodo curr = last.getSiguiente();
		
		while (curr != next) {
			last.setSiguiente(curr.getSiguiente());
			curr.setSiguiente(prev.getSiguiente());
			prev.setSiguiente(curr);
			curr = last.getSiguiente();
		}
		
		return last;
	}
	
	public Nodo reverse(Nodo n) {
		Nodo prev = null;
		Nodo curr = n;
		Nodo next = null;
		
		while(curr!=null) {
			next = curr.getSiguiente();
			curr.setSiguiente(prev);
			prev = curr;
			curr = next;
		}
		
		n = prev;
		return n;
	}
	
	public void printList() {
		if(this.head == null) return;
		
		for(Nodo aux=this.head;aux!=null;aux=aux.getSiguiente())
			System.out.print(aux.getDato() + " > ");
		
		System.out.println("NULL");
		System.out.println();
	}
	
	public Nodo removeNthFromEnd(Nodo nodo, int position) {
		if(nodo == null) return null;
		
		Nodo aux = nodo;
		int len =0;
		while(aux != null) {
			len++;
			aux = aux.getSiguiente();
		}
		
		// remove 1st node
		int fromStart = len - position + 1;
		if(fromStart == 1) return nodo.getSiguiente();
		
		// remove non 1st node
		Nodo p = nodo;
		int i=0;
		while (p != null) {
			i++;
			if(i == fromStart-1) {
				p.setSiguiente(p.getSiguiente().getSiguiente());
			}
			p = p.getSiguiente();
		}
		return nodo;
	}
	
	public Nodo addTwoNumbers(Nodo l1, Nodo l2) {
		Nodo dummy = new Nodo(0);
		int carry = 0;
		
		Nodo p = l1, q = l2, curr = dummy;
		
		while(p != null || q != null) {
			int x = (p != null) ? p.getDato() : 0;
			int y = (q != null) ? q.getDato() : 0;
			
			int sum = x + y + carry;
			carry = sum / 10;
			curr.setSiguiente(new Nodo(sum % 10));
			curr = curr.getSiguiente();
			
			if(p != null) p = p.getSiguiente();
			if(q != null )q = q.getSiguiente();
		}
		
		if(carry > 0) curr.setSiguiente(new Nodo(carry));
		
		return dummy.getSiguiente();
	}
	
	public Nodo addTwoNumbersII(Nodo n1, Nodo n2) {
		Map<Integer,Integer> mp1 = new HashMap<Integer,Integer>();
		Map<Integer,Integer> mp2 = new HashMap<Integer,Integer>();
		
		//Nodo head,newNode = null;
		int i =1,j=1,carry=0,res=0;
		
		while(n1 != null) {
			mp1.put(i, n1.getDato());
			n1 = n1.getSiguiente();
			i++;
		}
		
		while(n2 != null) {
			mp2.put(j, n2.getDato());
			n2 = n2.getSiguiente();
			j++;
		}
		
		i--;j--;
		
		while(i>0 || j>0 || carry >0) {
			int a = i>0 ? mp1.get(i) : 0;
			int b = j>0 ? mp2.get(j) : 0;
			
			res = (a + b + carry) % 10;
			
			this.insert(res);
			
			carry = (a + b + carry) / 10;
			i--;j--;
		}
		return head;
	}

	public Nodo mergeTwoLists(Nodo n1, Nodo n2) {
		Map<Integer,Integer> mp1 = new TreeMap<Integer,Integer>();
		int i=0;
		
		while(n1!=null) {
			mp1.put(i,n1.getDato());
			n1 = n1.getSiguiente();
			i++;
		}
		
		while(n2!=null) {
			mp1.put(i, n2.getDato());
			n2 = n2.getSiguiente();
			i++;
		}
		
		SortedSet<Map.Entry<Integer, Integer>> set = Common.entriesSortedByValues(mp1);
		Iterator<Map.Entry<Integer,Integer>> it = set.iterator();
		
		while(it.hasNext()) {
			this.insertToTheLast(it.next().getValue());
		}
		
		/*Set<Entry<Integer,Integer>> entry = mp1.entrySet();
		
		for (Entry<Integer,Integer> e : entry) {
			this.insertToTheLast(e.getValue());
		}
		*/
		return head;
	}
	
	public Nodo mergeKLists(Nodo[] lists) {
		if(lists == null || lists.length == 0) return null;
		
		Comparator<Nodo> comp = Comparator.comparing(Nodo->Nodo.getDato());
		PriorityQueue<Nodo> queue = new PriorityQueue<Nodo>(comp);
		
		Nodo head = new Nodo(0);
		Nodo p = head;
		
		for(Nodo list : lists) {
			if(list != null) queue.offer(list);
		}
		
		while(!queue.isEmpty()) {
			Nodo n = queue.poll();
			p.setSiguiente(n);
			p = p.getSiguiente();
			
			if(n.getSiguiente() != null) queue.offer(n.getSiguiente());
		}
		
		return head.getSiguiente();
	} 
	
	public Nodo rotar(Nodo nodo, int k) {
		
		if (nodo == null || k == 0) return nodo;
		
		Nodo current  = nodo;
		int count  = 1;
		
		while(current.getSiguiente() != null) {
			current = current.getSiguiente();
			count++;
		}
		
		if (current == null) return nodo;
		
		current.setSiguiente(nodo);
		
		int x= count-k % count;
		Nodo kthNodo = current;
		
		while (x>0) {
			kthNodo = kthNodo.getSiguiente();
			x--;
		}
		
		nodo = kthNodo.getSiguiente();
		kthNodo.setSiguiente(null);
		
		return nodo;
	}
	
	public Nodo swapPairs(Nodo nodo) {
		if(nodo == null || nodo.getSiguiente()== null) return nodo;
		
		Nodo h = new Nodo(0);
		h.setSiguiente(nodo);
		Nodo p = h;
		
		while(p.getSiguiente() != null && p.getSiguiente().getSiguiente()!=null) {
			Nodo t1 = p;
			p = p.getSiguiente();
			t1.setSiguiente(p.getSiguiente());
			
			Nodo t2 = p.getSiguiente().getSiguiente();
			p.getSiguiente().setSiguiente(p);
			p.setSiguiente(t2);
		}
		
		return h.getSiguiente();
	}
	
	public Nodo reverseBetween(Nodo nodo, int m, int n) {
		if(m==n) return nodo;
		
		Nodo revs=null, revend=null, revs_prev=null, revend_next=null;
		
		int i =1;
		Nodo curr = nodo;
		
		while (curr != null && i<=n) {
			if (i < m) revs_prev = curr;
			if (i == m) revs = curr;
			if (i == n) {
				revend = curr;
				revend_next = curr.getSiguiente();
			}
			
			curr = curr.getSiguiente();
			i++;
		}
		
		revend.setSiguiente(null);
		
		revend = reverse(revs);
		
		if(revs_prev != null) revs_prev.setSiguiente(revend);
		else nodo = revend;
		
		revs.setSiguiente(revend_next);
		return nodo;
	}
	
	public boolean cycleInList(Nodo n) {
		HashSet<Nodo> h = new HashSet<Nodo>();
		
		while(n !=null) {
			if (h.contains(n)) return true;
			
			h.add(n);
			n = n.getSiguiente();
		}
		
		return false;
	}
	
	public Nodo cycleList(Nodo nodo) {
		HashSet<Nodo> h = new HashSet<Nodo>();
		Nodo temp = nodo;
		
		while(temp != null) {
			if(h.contains(temp)) return temp;
			
			h.add(temp);
			temp = temp.getSiguiente();
		}
		
		return null;
	}
	
}
