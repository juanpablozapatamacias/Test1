package training.searches;

import java.util.HashSet;
import java.util.Set;

public class Count {
	
	private static int binarySearch(int[]arr, int x) {
		int n = arr.length-1;
		//mergeSort(arr);
		
		return binarySearch(arr, 0, n, x);
	}
	
	private static void mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			mergeSort(l);
			mergeSort(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}

	private static int binarySearch(int[] arr, int left, int right, int x) {
		// TODO Auto-generated method stub
		if(right >= left) {
			int mid = left + (right-left) / 2;
			
			if(x==arr[mid]) return mid;
			else if (x<arr[mid]) return binarySearch(arr,left,mid-1,x);
			else return binarySearch(arr,mid+1,right,x);
		}
		
		return -1;
	}
	
	private static int[] removeDuplicates(int[] arr) {
		int[] tempArr = new int [arr.length];
		int j=0;
		
		for(int i=0;i<arr.length-1;i++) {
			
			if(arr[i] != arr[i+1])
				tempArr[j++] = arr[i];
		}
		
		tempArr[j++] = arr[arr.length-1];
		
		for(int i=0;i<j;i++) {
			arr[i] = tempArr[i];
		}
		
		return arr;
	}
	
	public static int countPairs(int[] arr, int k) {
		int cont=0;
		
		// Remove the duplicate elements if any
		int[] arrNoDup = removeDuplicates(arr);
		int n = arrNoDup.length - 1;
		
		// Do the count pairs
		for (int i = 0; i < arrNoDup.length-1; i++)
			if(binarySearch(arrNoDup, i+1, n-1, arrNoDup[i]+k) != -1){
				cont++;
			}
				
		return cont;
	}
	
	public static boolean countPairsWithSum(int[] arr, int x) {
		Set<Integer> comp = new HashSet<Integer>();
		
		for(int val : arr) {
			if(comp.contains(x-val)) return true;
			
			comp.add(val);
		}
		
		return false;
	}
	
	public static boolean countPairsWithSum(int[] arr, int n, int sum) {
		int l = 0;
		int r = n - 1;
		
		while(l<r) {
			if(arr[l] + arr[r] == sum) return true;
			else if (arr[l] + arr[r] < sum) l++;
			else r--;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 1, 1, 2, 3, 4, 3, 4, 5, 6, 5, 6, 7, 7, 3};
		
		// Sort elements to the array to count the pairs
		mergeSort(A);
				
		int cont = countPairs(A,5);
		System.out.println(cont);
		
		// Another method to apply for count pairs using hashset
		System.out.println("Count pairs by using a boolean method, using hash set");
		System.out.println(countPairsWithSum(A,5) ? "YES" : "NO");
		
		// Another boolean method
		System.out.println("Count pairs by using a boolean method, using an array");
		System.out.println(countPairsWithSum(A,A.length,5) ? "YES" : "NO");
	}

}
