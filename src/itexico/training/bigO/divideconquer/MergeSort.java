package itexico.training.bigO.divideconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void merge1(int[] arr, int[] l, int[] r, int left, int right) {
		int i=0,j=0,k=0;
		
		while(i<left && j<right) {
			if(l[i] <= r[j])
				arr[k++] = l[i++];
			else
				arr[k++] = r[j++];
		}
		
		while(i < left)
			arr[k++] = l[i++];
		
		while(j < right)
			arr[k++] = r[j++];
		
	}
	
	public static void mergeSort1(int[] arr, int n) {

		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		
		if (n < 2) return;
		
		for(int i=0;i<mid;i++) {
			l[i] = arr[i];
		}
		
		for (int j=mid;j<n;j++) {
			r[j - mid] = arr[j];
		}
		
		mergeSort1(l, mid);
		mergeSort1(r,n-mid);
		
		merge1(arr,l,r,mid,n-mid);
		
	}
	
	public static void mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int [mid];
		int[] r = new int [range];
		
		if (n>=2) {
			
			for(int i=0;i<mid;i++) l[i]=arr[i];
			for(int j=mid;j<n;j++) r[j-mid]=arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
			
			while (i< l.length && j < r.length) {
				if(l[i] <= r[j]) {
					arr[k++] = l[i++];
				}
				else {
					arr[k++] = r[j++];
				}
			}
			
			while(i < l.length) {
				arr[k++] = l[i++];
			}
			
			while(j < r.length) {
				arr[k++] = r[j++];
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] arg) {
		int[] arr = {6,2,8,3,7};
		mergeSort1(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		
		int[] arr1 = {5,2};
		mergeSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}
}
