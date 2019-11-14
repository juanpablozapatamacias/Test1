package itexico.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Arreglo {
	
	public static int[] reverseArray(int[] a) {
		int[] b = new int[a.length];
		int j = a.length;
		
		for(int i=0;i<a.length;i++) {
			b[j-1] = a[i];
			j--;
		}
		return b;
	}
	
	public static void main(String[] argv) {
		int[] a = {1,4,3,2};
		int[] b = {9,8,7,6};
		int[] c = {1,2,2,3,3,3,3,3,4,7,8,8,4};
		
		int[] rev = reverseArray(a);
		
		for(int i=0;i<rev.length;i++)
			System.out.print(rev[i] + " ");
		
		System.out.println("El valor minimo absoluto de un arreglo es: " + minimumDifference(a));
		
		int[] join = joinArrays(a,b);
		
		for(int j=0;j<join.length;j++) {
			System.out.print(join[j] + " ");
		}
		
		System.out.println("La media de dos arreglos es " + findMedianSortedArrays
				(new int[] {1,3},new int[] {2}));
		
		int[] ff = findFirstAndLast(c,4);
		for (int i=0;i<ff.length;i++)
			System.out.print(ff[i] + " ");
		
		System.out.println();
		System.out.println(searchInsert(a,5));
		
		int[] result = mergeKSortedArray(new int[][] {a,b,c});
		
		System.out.println(Arrays.toString(result));
		
		int[] dup1 = {10,20,30};
		int[] dup2 = {20,25,30,40,50};
		System.out.println(findNonDuplicated(dup1,dup2));
		
		System.out.println(findAllDuplicated(new int[]{4,3,2,7,8,2,3,1}));
		
		System.out.println(removeElement(new int[] {0,1,2,2,3,0,4,2},2));
		
		System.out.println(findDuplicated(new int[] {0,1,2,2,3,0,4,2}));
		
		System.out.println(singleNumber(new int[] {0,1,2,2,3,0,4,2}));
		
		System.out.println(removeDuplicates(new int[] {1,2,1,1,2,3}));
		
		System.out.println(binarySearch(new int[] {2,5,6,8,9,10},9) != -1 ? 
				"Element found":"Element not found");
		
		int[][] A = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(A,13) ? 
				"Element found":"Element not found");
		System.out.println(searchMatrixII(A,13) ? 
				"Element found":"Element not found");
	}
	
	public static int minimumDifference(int[] a) {
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<a.length-1; i++) {
			int currentMin = Math.abs(a[i] - a[i+1]);
			min = Math.min(min, currentMin);
		}
		return min;
	}
	
	public static int[] joinArrays(int[] ar1, int[] ar2) {
		int[] ar3 = new int[ar1.length + ar2.length];
		int count = 0;
		
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		
		for(int i=0;i<ar1.length;i++) {
			ar3[i] = ar1[i];
			count++;
		}
		
		for(int j=0;j<ar2.length;j++) {
			ar3[count++] = ar2[j];
		}
		
		return ar3;
	}
	
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int[] arr = merge(A,B);
		//int[] arr = joinArrays(A,B);
		int medianIndex = (int)Math.ceil((A.length+B.length)/2.0) - 1;
		int needAverage = (A.length+B.length) % 2;
		if(needAverage==0) return (arr[medianIndex] + arr[medianIndex+1])/2.0;
		
		return arr[medianIndex];
	}
	
	private static int[] merge(int[] arr1, int[] arr2) {
		int i=0,j=0;
		int[] arr = new int[arr1.length+arr2.length];
		
		while(i+j < arr.length) {
			if(i==arr1.length) arr[i+j] = arr2[j++];
			else if(j==arr2.length) arr[i+j]=arr1[i++];
			else if(arr1[i] < arr2[j]) arr[i+j] = arr1[i++];
			else arr[i+j] = arr2[j++];
		}
		
		return arr;
	}
	
	public static int[] findFirstAndLast(int arr[], int target) {
		int[] res = new int[2];
		int n = arr.length;
		int first = -1, last = -1;
		
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			if(target != arr[i]) continue;
			if(first == -1) first=i;
			
			last = i;
		}

		res[0] = first;
		res[1] = last;

		return res;
	}
	
	public static int searchInsert(int[] arr, int target) {
		int start = 0, end=arr.length - 1;
		int mid = 0;
		
		Arrays.sort(arr);
		
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			
			if(arr[mid] == target) return mid;
			else if (arr[mid] < target) start = mid;
			else end = mid;
		}
		
		if(arr[end] < target) return end + 1;
		else if(arr[start] >= target) return start;
		else return end;
	}
	
	public static void mergeArrays(int[] ar1, int m, int[] ar2, int n) {
		int i = m-1;
		int j = n-1;
		int k = m + n - 1;
		
		while(k >= 0) {
			ar1[k--] = (j < 0 || (i>=0 && ar1[i] > ar2[j])) ? ar1[i--] : ar2[j--];
		}
	}
	
	public static int[] mergeKSortedArray(int[][] arr) {
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total = 0;
		
		for(int i=0; i<arr.length; i++) {
			Arrays.sort(arr[i]);
			queue.add(new ArrayContainer(arr[i],0));
			total = total + arr[i].length;
		}
		
		int m = 0;
		int[] result = new int[total];
		
		while(!queue.isEmpty()) {
			ArrayContainer ac = queue.poll();
			result[m++] = ac.getArr()[ac.getIndex()];
			
			if(ac.getIndex() < ac.getArr().length-1) queue.add(new ArrayContainer(ac.getArr(),ac.getIndex()+1));
		}
		
		return result;
	}
	
	
	public static int[] sortedSquares(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		
		for(int i=0;i<n;i++) {
			ans[i] = arr[i] * arr[i];
		}
		
		Arrays.sort(ans);
		return ans;
	}
	
	public static List<Integer> findNonDuplicated(int[] a, int [] b){
		int[] c = new int[a.length + b.length];
		int i=0,j=0,k=0;
		
		List<Integer> res = new ArrayList<Integer>();
		
		while (i<a.length && j < b.length) {
			// if not common, print the smaller
			if(a[i] < b[j]) {
				res.add(a[i]);
				i++;
				k++;
			}
			else if(b[j] < a[i]) {
				res.add(b[j]);
				k++;
				j++;
			}
			else {
				i++;j++;
			}
		}
		
		while(i<a.length) {
			res.add(a[i]);
			i++;k++;
		}
		
		while(j<b.length) {
			res.add(b[j]);
			k++;j++;
		}
		
		
		return res;
	}
	
	public static List<Integer> findAllDuplicated(int[] arr){
		
		Arrays.sort(arr);
		
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> set  = new HashSet<Integer>();
		
		for(Integer i : arr) {
			if(set.contains(i)) res.add(i);
			
			set.add(i);
		}
		
		return res;
		
	}
	
	public static int removeElement(int[] nums, int val) {
		int i=0,j=0;
		while(j < nums.length) {
			if(nums[j] != val) {
				nums[i++] = nums[j];
			}
			j++;
		}
		return i;
	}
	
	public static int findDuplicated(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(Integer i : arr) {
			if(set.contains(i)) return i;
			
			set.add(i);
		}
		
		return -1;
	}
	
	public static int singleNumber(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(Integer i: arr) {
			if(!set.add(i)) set.remove(i);
		}
		
		Iterator<Integer> it = set.iterator();
		return it.next();
	}
	
	public static int removeDuplicates(int[] arr) {
		if(arr == null) return 0;
		if(arr.length <= 2) return arr.length;
		
		int i=1,j=2;
		Arrays.sort(arr);
		
		while(j < arr.length) {
			if(arr[j] == arr[i] && arr[j] == arr[i-1]) {
				j++;
			}
			else {
				i++;
				arr[i] = arr[j];
				j++;
			}
		}
		return i+1;
		
	}
	
	public static int binarySearch(int[] A, int x) {
		int left = 0, right = A.length-1;
		return binarySearch(A,left,right,x);
	}
	
	private static int binarySearch(int[] A, int left, int right, int x) {
		if (left > right) return -1;
		
		int mid = (left + right) / 2;
		
		if(x == A[mid]) return mid;
		else if(x < A[mid]) return binarySearch(A,left, mid-1, x);
		else return binarySearch(A,mid+1,right,x);
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length ==0 || matrix[0].length==0) return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start = 0;
		int end = m * n -1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			int midX = mid / n;
			int midY = mid % n;
			
			if(matrix[midX][midY] == target) return true;
			
			if(matrix[midX][midY] < target) start = mid+1;
			else end = mid -1;
		}
		return false;
	}
	
	public static boolean searchMatrixII(int[][] matrix, int target) {
		if (matrix == null || matrix.length ==0 || matrix[0].length==0) return false;
		
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		
		int i=m,j=0;
		
		while(i>=0 && j<=n) {
			if(target < matrix[i][j]) i--;
			else if (target > matrix[i][j]) j++;
			else return true;
		}
		
		return false;
	}
	

}
