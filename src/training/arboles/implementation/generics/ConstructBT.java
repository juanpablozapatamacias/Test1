package training.arboles.implementation.generics;

import java.util.HashMap;
import java.util.Map;

public class ConstructBT {
	
	public static Nodo<Integer> buildTree(int[] preorder, int[] inorder){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<inorder.length;++i) {
			map.put(inorder[i], i);
		}
		return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
	}

	private static Nodo<Integer> helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight,
			Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
		if(pLeft > pRight || iLeft > iRight) return null;
		
		int i = map.get(preorder[pLeft]);
		
		Nodo<Integer> cur = new Nodo<Integer>(preorder[pLeft]);
		
		cur.setLeft(helper(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1,map));
		cur.setRight(helper(preorder,pLeft +i - iLeft + 1, pRight, inorder, i+1, iRight, map));
		
		return cur;
		
	}

	public static void main(String[] arg) {
		int [] A = {3,9,20,15,7};
		int [] B = {9,3,15,20,7};
		
		Nodo<Integer> root = buildTree(A,B);
	}
}
