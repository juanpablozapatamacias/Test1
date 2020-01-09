package itexico.training.bigO;

import java.util.Arrays;

public class AlgorithmsBigO {

	public static void constantTime() {
		// Constant time O(1)
		int n = 1000;
		System.out.println("Constant time O(1)");
		System.out.println("Input is " + n);
	}
	
	public static void twoLoops(int n) {
		// Complexity = O(N) because the second loop is iterated with a constant value
		
		for(int i=0;i<n;i++) System.out.println(i);
		for(int i=0;i<100;i++ )System.out.println(i);
	}
	
	public static void twoLoops(int n, int m){
		// Complexity = O(N+M) iterations are added by using different inputs (n and m)
		
		for(int i=0;i<n;i++) System.out.println(i);
		for (int i=0;i<m;i++ )System.out.println(i);
	}	
	
	public static void twoLoops1(int n, int m) {
		// Complexity = O(N*M)
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.println(i*j);
			}
		}
	}
	
	public static void twoLoopsNestedAndNonNested(int n) {
		// Complexity = 0(N^2 + N) = O(N^2)
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println(i*j);
			}
		}
		
		for (int k=0;k<n;k++) System.out.println(k);
	}
	
	public static void twoForLoopsNotCompletelyStraightFwd(int n) {
		// Complexity = 2^k = N = O(log N)
		for(int i=0;i<n;i++) {
			for(int j=n;j<n/2;j--) {
				System.out.println(i + " " + j);
			}
		}
		
	}
	
	public static void doublingLoopVariable(int n) {
		// Complexity = O(2^N)
		for(int j=1;j<n;) {
			System.out.println(j);
			j=j*2;
		}
		
	}
	
	public static void logarithmicTime() {
		// Logarithmic time O (log n)
		System.out.println("Logarithmic time O (log n)");
		for(int i=1;i<10;i++) {
			System.out.println("Iteration " + i);
		}
	}
	
	public static void foo(int[] arr) {
		//this will take O(N) time by iterating the array twice
		// this is the same case as O(N + log N)
		int sum = 0;
		int prod = 1;
		
		for(int i=0;i<arr.length;i++)
			sum += arr[i];
		
		for(int i=0;i<arr.length;i++) {
			prod *= arr[i];
		}
		
		System.out.println(sum + " " + prod);
	}
	
	public static void foo2(int arr1[], int arr2[][]) {
		// this will take O(N + N2) time - usually classified as worst case execution
		
		int a1 = arr1.length;
		
		int b1 = arr2.length;
		int b2 = arr2[0].length;
		
		// the next lopp indicates that are applicable to multi part algorithms,
		// that means O(A*B) where A contains a different size than B
		for (int i=0;i<a1;i++) {
			System.out.println(arr1[i]);
			for (int j=0;j<b1;j++)
				for(int k=0;k<b2;k++)
					System.out.println(arr2[j][k]);
		}
	}
	
	public static int fibonacci(int n) {
		//this will take O(2^n) time
		if (n <= 1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-1);
	}
	
	public static void sequentialSearch(int[] arr, int target) {
		// this will take O((n+1)/2)
		int n = arr.length;
		for (int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				System.out.println("El elemento " + target + " se encuentra en el indice " + i);
				break;
			}
		}
	}
	
	public static int binarySearch(int[] arr, int target) {
		// this will take O(log N) time
		int start = 0;
		int end = arr.length - 1;
		int pivot = 0;
		int i=0;
		
		Arrays.sort(arr);
		
		while(start <= end) {
			pivot = start + (end - start) / 2;
			
			if(arr[pivot] == target) return pivot;
			if(arr[pivot] < target) start = pivot+1;
			if(arr[pivot] > target) end = pivot-1;
			
		}
		return -1;
	}
	
	public static int binarySearchRec(int[] arr, int y) {
		int left = 0, right = arr.length-1;
		Arrays.sort(arr);
		return binarySearch(arr,left,right,y);
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
	
	public static int[] bubbleSort(int[] arr) {
		// this will take O(n^2) time
		int temp =0;
		
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr.length-1;j++) {
				if(arr[i]<arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				} 
			}
		}
		return arr;
	}
	
	public static void quickSort(int arr[], int low, int high) {
		// takes a O(n log(n)) time for execution
		
		if(low < high) {
			int pi = partition(arr,low,high);
			
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
		
		
	}
	
	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[high];
		int i = (low-1);
		int temp =0;
		
		for (int j=low;j<high;j++) {
			if(arr[j] < pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;

	}

	public static boolean isPrime(int n) {
		for(int x=2;x<=Math.sqrt(n);x++)
			if(n % x==0) return false;
		
		return true;
	}
	
	public static void main(String[] arg) {
		//constantTime();
		//System.out.println();
		//logarithmicTime();
		//foo(new int[] {4,2,8,9});
		//foo2(new int[] {4,3,2}, new int[][] {{1,2},{3,4},{5,6}});
		System.out.println(fibonacci(5));
		System.out.println(isPrime(7));
		System.out.println(Arrays.toString(bubbleSort(new int[] {5,6,2,3,1,4})));
		System.out.println(binarySearch(new int[] {5,4,3,7,8},4));
		System.out.println(binarySearchRec(new int[] {5,4,3,7,8},4));
		
		int[] arr4 = new int[] {6,5,7,1};
		quickSort(arr4,0,arr4.length-1);
		System.out.println(Arrays.toString(arr4));
	}
	
}
