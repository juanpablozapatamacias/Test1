package training.searches;

import java.util.Arrays;

public class BinarySearch {

	public int binarySearchWithQuickSort(int[] arr, int target) {
		int start = 0;
		int end = arr.length;
		int pivot = 0;
		
		quickSort(arr,0,arr.length-1);
		
		while(start <= end) {
			pivot = end + (start - end) /2;
			if(arr[pivot] == target) return pivot;
			if(arr[pivot] < target) start = pivot + 1;
			if(arr[pivot] > target) end = pivot -1;
		}
		
		return -1;
	}
	
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private void quickSort(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i<j) {
			int piv = partition(arr,i,j); 
			
			quickSort(arr,i,piv-1);
			quickSort(arr,piv+1,j);
		}
	}

	private int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[high];
		int i = (low-1);
		int temp = 0;
		
		for (int j=low;j<high;j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr,i,j);
			}
		}

		swap(arr,i+1,high);
		return i+1;
	}
	
	public int binarySearchMergeSort(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		int pivot = 0;
		
		mergeSort(arr);
		
		while(start <= end) {
			pivot = start + (end - start) / 2;
			
			if(arr[pivot] == target) return pivot;
			if(arr[pivot] < target) start = pivot+1;
			if(arr[pivot] > target) end  = pivot-1;
			
		}
		
		return -1;
	}
	
	private void mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int mid = n >> 1;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		
		if (n>2) {
			
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
					
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) {
					arr[k++] = l[i++];
				}
				else {
					arr[k++] = r[j++];
				}
			}
			
			while (i < l.length) {
				arr[k++] = l[i++];
			}
			
			while (j < r.length) {
				arr[k++] = r[j++];
			}
		}
	}
	
	public int binarySearchBubbleSort(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		int pivot = 0;
		
		bubbleSort(arr);
		
		while (start <= end) {
			pivot = start + (end-start) / 2;
			
			if(arr[pivot]==target) return pivot;
			if(arr[pivot]<target) start = pivot + 1;
			if(arr[pivot]>target) end = pivot - 1;
		}
		
		return -1;
	}

	private void bubbleSort(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i] < arr[j]) 
					swap(arr,i,j);
			}
		}
	}
	
	public int binarySearchRecursive(int[] arr, int x) {
		int n = arr.length;
		Arrays.sort(arr);
		
		return binarySearch(arr,0,n-1,x) ;
	}
	
	private static int binarySearch(int[] A, int left, int right, int x) {
		// this will take O(log N) time
		
		if (right >= left) {
			int mid = right + (left - right) / 2;
			
			if(x == A[mid]) return mid;
			else if(x < A[mid]) return binarySearch(A,left, mid-1, x);
			else return binarySearch(A,mid+1,right,x);
		}
		
		return -1;
		
	}
	
	public static void main(String[] argv) {
		BinarySearch bs = new BinarySearch();
		int[] arr = {6,4,5,7,8,0,1};
		
		int[] aux = Arrays.copyOf(arr, arr.length);
		System.out.println(bs.binarySearchWithQuickSort(aux,4));
		System.out.println(Arrays.toString(aux));
		
		int[] aux1 = {4,3,9};
		System.out.println(bs.binarySearchMergeSort(aux1, 3));
		System.out.println(Arrays.toString(aux1));
		
		int[] aux2 = {4,1};
		System.out.println(bs.binarySearchBubbleSort(aux2, 1));
		System.out.println(Arrays.toString(aux2));
		
		int[] aux3 = {8,5,6,9,1,2};
		System.out.println(bs.binarySearchRecursive(aux3, 9));
		System.out.println(Arrays.toString(aux3));
	}
	
}
