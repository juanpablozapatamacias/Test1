package training.dfs;

import java.util.Map;

public class ConstructBinaryTreePreorderInorderTrav {
	
	public static NodoTree<Integer> build(int[] inorder, int[] postorder){
		return helper(inorder, postorder, 0, inorder.length -1, postorder.length-1);
		
	}
	
	private static NodoTree<Integer> helper(int[] inorder, int[] postorder, int instart, int inend, int postend) {
		// TODO Auto-generated method stub
		if(postend <0 || instart > inend) return null;
		
		NodoTree<Integer> root =new NodoTree<Integer>(postorder[postend]);
		
		int i = instart;
		
		
		while(i < inend) {
			if(inorder[i] == root.getDato()) break;
			i++;
		}
		
		root.setLeft(helper(inorder,postorder,instart,i-1,postend-1+i-inend));
		root.setRight(helper(inorder,postorder,i+1,inend,postend-1));
		
		return root;
	}



	public static void main(String[] args) {
		int[] A = {9,3,15,20,7};
		int[] B = {9,15,7,20,3};
		
		NodoTree<Integer> res = build(A,B);
	}

}
