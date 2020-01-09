package itexico.training.searches;

import java.util.Arrays;

public class BinarySearchRecursive {
	static int mid = 0;
	
	public static int binarySearch(int[] arr, int start, int end, int x) {
		mid = start + (end-start) / 2;
		
		if(start >= arr.length) return arr.length+1;
		if(end < start) return start + 1;
		
		if(x>arr[mid]) return binarySearch(arr,start,mid-1,x);
		else if(x<arr[mid]) return binarySearch(arr,mid+1,end,x);
		else return mid +1;
		
	}
	
	public static void mergeSort(int[] arr) {
		int n = arr.length;
		mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if (n>=2) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<r.length) {
				if(l[i]<=r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {99,10,55,32,100,65,1,69};
		System.out.println("Before Sorting: " + Arrays.toString(A));
		mergeSort(A);
		System.out.println("After Sorting: " + Arrays.toString(A));
		
		System.out.println("Gets value: " 
				+ binarySearch(A,0,A.length,32));
	}

}
