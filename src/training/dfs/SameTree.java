package training.dfs;

public class SameTree {
	static NodoTree<Integer> root;
	
	public static boolean isSame(NodoTree<Integer> p, NodoTree<Integer> q) {
		if(p == null && q == null) return true;
		else if(p==null || q==null) return false;
		else if(p.getDato() != q.getDato()) return false;
		else return isSame(p.getLeft(), q.getLeft()) && isSame(p.getRight(), q.getRight());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodoTree<Integer> a = new NodoTree<>(1);
		a.setLeft(new NodoTree<>(2));
		a.setRight(new NodoTree<>(3));
		
		NodoTree<Integer> b = new NodoTree<>(1);
		b.setLeft(new NodoTree<>(2));
		b.setRight(new NodoTree<>(3));
		
		System.out.println(isSame(a,b));
	}

}
