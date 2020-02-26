package training.bigO.divideconquer;

import java.util.Arrays;

public class MergeSortChar {

	public static void mergeSort(char[] arr) {
		int n = arr.length;
		int mid = n / 2;
		
		char[] l = new char[mid];
		char[] r = new char[n-mid];
		
		if(n >= 2) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			merge(arr,l,r,mid,n-mid);
		}
	}
	
	private static void merge(char[] arr, char[] l, char[] r, int left, int right) {
		// TODO Auto-generated method stub
		int i=0,j=0,k=0;
		
		while(i<left && j<right) {
			if(l[i]<=r[j]) arr[k++] = l[i++];
			else arr[k++] = r[j++];
		}
		
		while(i<left) arr[k++] = l[i++];
		while(j<right) arr[k++] = r[j++];
		
	}

	public static void main(String[] argv) {
		String s = "Zapata";
		char[] c = s.toLowerCase().toCharArray();
		mergeSort(c);
		System.out.println(Arrays.toString(c));
	}
}
