package training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayRotation {
	public static void leftRotate(int[] arr, int d) {
		System.out.println("Input Array Before Rotation: ");
		System.out.println(Arrays.toString(arr));
		
		int n = arr.length;
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,n-1);
		reverseArray(arr,0,n-1);
		
		System.out.println("Input Array Left Rotation by " +d+ " Positions:");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void rightRotate(int[] arr, int d) {
		System.out.println("Input Array Before Rotation: ");
		System.out.println(Arrays.toString(arr));
		
		int n = arr.length;
		reverseArray(arr,0,n-1);
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,n-1);
		
		System.out.println("Input Array Right Rotation by " +d+ " Positions:");
		System.out.println(Arrays.toString(arr));
	}
	
	public static int search(int[] ar, int target) {
		int index;
		for (int i=0;i<ar.length;i++) {
			if(target == ar[i]) {
				index = i;
				return index;
				
			}
		}
		return -1;
	}
	
	public static boolean searchII(int[] ar, int target) {
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int cont = 0;
		
		for(int a : ar) {
			if(map.get(a) == null) cont = 1;
			else cont =  map.get(a) + 1;
			
			map.put(a, cont);
		}
				
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getKey() == target) return true;
		}
		
		return false;
	}
	
	public static void main(String[] arg) {
		int[] a = {1,2,3,4,5,6,7};
		leftRotate(a,2);
		System.out.println(search(a,6));
		System.out.println(search(a,0));
		System.out.println();
		System.out.println(searchII(a,6));
		System.out.println(searchII(a,9));
		
		rightRotate(a,4);
	}

}
