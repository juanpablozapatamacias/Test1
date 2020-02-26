package itexico.training.arrays;

public class FindPeakElement {
	
	public static int find(int[] arr) {
		return find(arr,0,arr.length-1);
	}

	private static int find(int[] arr, int i, int j) {
		if(i==j) return i;
		
		int mid = (i + j) / 2;
		
		if(arr[mid] > arr[mid+1]) return find(arr,i,mid);
		else return find(arr,mid+1,j);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,1,3,5,6,4};
		System.out.println(find(A));
	}

}
