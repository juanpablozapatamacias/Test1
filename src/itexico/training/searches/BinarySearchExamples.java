package itexico.training.searches;

import java.util.Arrays;

public class BinarySearchExamples {

	static int mid;
	static int n;
	
	private static int binarySearchRecursive(int[] arr, int left, int right, int x) { 
		if(right >= left) {
			mid = left + (right - left) / 2;
			if(arr[mid] == x) return mid;
			else if(x < arr[mid]) return binarySearchRecursive(arr,left,mid-1,x);
			else return binarySearchRecursive(arr,mid+1,right,x);
		}
		return -1;
	}
	
	public static void merge(int[] a) {
		n = a.length;
		mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = a[i];
			
			for(int j=mid;j<n;j++) r[j-mid] = a[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) a[k++] = l[i++];
				else a[k++] = r[j++];
			}
			
			while(i<l.length) a[k++] = l[i++];
			while(j<r.length) a[k++] = r[j++];
		}	
	}
	
	public static int binarySearchNonRecursive(int[] arr, int target) {
		int start = 0;
		int pivot = 0;
		int end = arr.length-1;
		
		/*
		while(start <= end) {
			pivot = start + (end - start) / 2; 
			if(arr[pivot] == x) return pivot;
			if(arr[pivot] < x) start = pivot + 1;
			if(arr[pivot] > x) end = pivot - 1;
		}
		*/
		
		while (start <= end) {
			pivot = start + (end-start) / 2;
			
			if(arr[pivot]==target) return pivot;
			if(arr[pivot]<target) start = pivot + 1;
			if(arr[pivot]>target) end = pivot - 1;
		}
		
		
		return -1;
	}
	
	public static void searchValueWithRecursive(int[] arr, int x) {	
		System.out.println("Arreglo antes de ordenar: " + Arrays.toString(arr));
		merge(arr);
		System.out.println("Arreglo despues de ordenar: " + Arrays.toString(arr));
		System.out.println(binarySearchRecursive(arr,0,arr.length-1,x) != -1 ? "Valor encontrado" : "Valor no encontrado");
	}
	
	public static void searchValueNonRecursive(int[] arr, int x) {
		System.out.println("Arreglo antes de ordenar: " + Arrays.toString(arr));
		merge(arr);
		System.out.println("Arreglo despues de ordenar: " + Arrays.toString(arr));
		System.out.println(binarySearchNonRecursive(arr,x) != -1 ? "Valor encontrado" : "Valor no encontrado");
	}
	
	public static void main(String[] arg) {
		int[] A = {6,5,2,9,10,55,22,33};
		int[] B = Arrays.copyOf(A, A.length);
		int[] C = Arrays.copyOf(A, A.length);
		
		searchValueWithRecursive(A,55);
		searchValueWithRecursive(B,8);
		
		searchValueNonRecursive(C,22);
		
		
	}
}
