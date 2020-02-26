package itexico.training.arboles.implementation.generics;

public class KthSmallElementBST {
	
	static Nodo<Integer> root;

	public static int smallest(Nodo<Integer> root, int k) {
		int[] nums = new int[2];
		inorder(root,nums,k);
		
		return nums[1];
	}
	
	private static void inorder(Nodo<Integer> root, int[] nums, int k) {
		// TODO Auto-generated method stub
		if(root == null) return;
		
		inorder(root.getLeft(),nums,k);

		if(++nums[0] == k) {
			nums[1] = root.getData();
			return;
		}
		
		inorder(root.getRight(),nums,k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
