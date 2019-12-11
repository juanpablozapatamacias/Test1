package itexico.training.searches;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPairs {
	
	static Set<Integer> set = new HashSet<Integer>();
	static int n;
	static int m;

	private static void mergeSort(int[] arr) {
		n = arr.length;
		
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
			
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) 
					arr[k++] = l[i++];
				else
					arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}
	
	public static boolean isPairWithSum(int[][] arr, int sum) {

		n = arr.length;
		m = arr[0].length;
		
		for (int i=0;i<n;i++) {
			mergeSort(arr[i]);
			
			for(int j=0;j<m;j++) {
				if (set.contains(sum - arr[i][j])) return true;	
				set.add(arr[i][j]);
			}
		}
		
		return false;
	}
	
	public static boolean isPairWithProd(int[][] arr, int prod) {
		n = arr.length;
		m = arr[0].length;
		
		for (int i=0;i<n;i++) {
			mergeSort(arr[i]);
			
			for(int j=0;j<m;j++) {
				if((prod % arr[i][j] == 0) && set.contains(prod / arr[i][j])) return true;
				set.add(arr[i][j]);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {6,4,5,3,10};
		mergeSort(A);
		System.out.println(Arrays.toString(A));
		
		int[][] B = {{4,2,3,1},
					 {5,6,8,7},
					 {12,10,9,11},
					 {14,13,16,15}};
		
		System.out.println("Pair sum using a matrix");
		System.out.println(isPairWithSum(B,100) ? "YES" : "NO");
		System.out.println(Arrays.toString(B[0]));
		
		System.out.println("Pair prod using a matrix");
		System.out.println(isPairWithProd(B,42) ? "YES" : "NO");
	}

}
