package itexico.training.arrays;

import java.util.Arrays;

public class FindMinimumRotatedArrays {
	
	static int n = 0;
	
	public static void reverseArray(int[] arr, int start, int end) {
		int temp;
		
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void leftRotate(int[] arr, int d) {
		n = arr.length;
		
		System.out.println("Array before rotation");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Left Rotate");
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,n-1);
		reverseArray(arr,0,n-1);
		
		System.out.println("Array rotated by " +d+ " elements");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void rightRotate(int[] arr, int d) {
		n = arr.length;
		
		System.out.println("Array before rotation");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Right Rotate");
		reverseArray(arr,0,n-1);
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,n-1);
		
		System.out.println("Array rotated by " +d+ " elements");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for (int i=0;i<mid;i++) l[i] = arr[i];
			for (int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<l.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}
	
	public static int findMin(int [] arr) {
		return findMin(arr,0,arr.length-1);
	}

	private static int findMin(int[] arr, int low, int high) {
		int mid = 0;
		while(low <= high) {
			
			while(arr[low] == arr[high] && low != high) low++;
			
			if(arr[low] <= arr[high]) return arr[low];
			
			mid = low + (high - low) / 2;
			
			if(arr[mid] >= arr[low]) low = mid+1;
			else high=mid;
		}
		
		return -1;
	}
	
	public static void main(String[] arg) {
		int[] A= {9,1,5,2,10,3,5};
		
		mergeSort(A);
		System.out.println(findMin(A,0,A.length-1));
		
		leftRotate(A,2);
		System.out.println(findMin(A,0,A.length-1));
		
		mergeSort(A);
		System.out.println(findMin(A,0,A.length-1));
		
		rightRotate(A,3);
		System.out.println(findMin(A,0,A.length-1));
	}

}


