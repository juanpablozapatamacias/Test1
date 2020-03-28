package training.sorting.mergesort;

import java.util.Arrays;

public class MergeSortAlgorithm implements MergeSort{
	
	long count=0;

	@Override
	public void merge(int[] arr, int[] l, int[] r, int left, int right) {
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
	
	@Override
	public void mergeSort(int[] arr, int n) {

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
		
		mergeSort(l, mid);
		mergeSort(r,n-mid);
		merge(arr,l,r,mid,n-mid);
	}

	@Override
	public void mergeSort(int[] arr) {
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

	
}
