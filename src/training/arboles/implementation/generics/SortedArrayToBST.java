package training.arboles.implementation.generics;

public class SortedArrayToBST {
	
	static Nodo<Integer> root;
	
	public static Nodo<Integer> sortedArrayToBST(int[] nums){
		if(nums == null || nums.length==0) return null;
		
		merge(nums);
		
		return constructBSTRecursive(nums,0,nums.length-1);
	}
	
	private static Nodo<Integer> constructBSTRecursive(int[] nums, int left, int right) {
		if(left > right) return null;
		
		int mid = left + (right - left) / 2;
		Nodo<Integer> current = new Nodo<Integer>(nums[mid]);
		
		current.setLeft(constructBSTRecursive(nums,left,mid-1));
		current.setRight(constructBSTRecursive(nums,mid+1,right));
		
		
		return current;
	}

	public static void merge(int[] arr) {
		int n= arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,9,0,-3,-10};
		Nodo<Integer> res = sortedArrayToBST(A);
	}

}
