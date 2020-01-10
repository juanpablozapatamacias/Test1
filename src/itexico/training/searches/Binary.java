package itexico.training.searches;

import java.util.Arrays;

public class Binary {
	
	public static int binarySearch(int[] arr, int number) {
		int min = 0;
		int max = arr.length -1;
		int mid;
		
		while(min <= max) {
			mid = min + (max - min) / 2;
			
			if(arr[mid] == number) return mid;
			if(arr[mid] > number) max = mid -1;
			else min = mid + 1;
		}
		return -1;
	}
	
	public static void mergeSort(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int [mid];
		int[] r = new int [range];
		
		if(n>=2) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			} 
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];
		}
		
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {6,3,10,2,4,5,9,8,1,7};
		mergeSort(A);
		binarySearch(A,10);
	}

}
