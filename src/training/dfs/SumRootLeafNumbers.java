package training.dfs;

public class SumRootLeafNumbers {
	static NodoTree<Integer> root;
	
	public static int sum(NodoTree<Integer> root) {
		if(root == null) return 0;
		
		return dfs(root,0,0);
	}

	private static int dfs(NodoTree<Integer> root, int num, int sum) {
		// TODO Auto-generated method stub
		if(root == null) return sum;
		
		num = num * 10 + root.getDato();
		
		if(root.getLeft()==null && root.getRight()==null) {
			sum+=num;
			return sum;
		}
		
		sum = dfs(root.getLeft(),num,sum) + dfs(root.getRight(),num,sum);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new NodoTree<>(3);
		root.setLeft(new NodoTree<>(9));
		root.setRight(new NodoTree<>(1));
		
		root.getRight().setLeft(new NodoTree<>(2));
		root.getRight().setRight(new NodoTree<>(7));
		
		System.out.println(sum(root));
	}

}
