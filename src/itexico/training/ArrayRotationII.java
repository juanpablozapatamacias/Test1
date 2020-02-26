package itexico.training;

import java.util.Arrays;

public class ArrayRotationII {
	
	public static void rotateRight(int[] arr, int k) {
		// Displays origin array
		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<k;i++) {
			int j, last;
			last = arr[arr.length-1];
			for (j=arr.length-1;j>0;j--) {
				arr[j] = arr[j-1];
			}
			arr[0] = last;
		}
		
	}
	
	public static void rotateLeft(int[] arr, int k) {
		// Displays origin array
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<k;i++) {
			int j,first;
			first = arr[0];
			for(j=0;j<arr.length-1;j++) {
				arr[j] = arr[j+1];
			}
			arr[j] = first;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,7};
		//rotateRight(A,3);
		rotateLeft(A,3);
		
		System.out.println(Arrays.toString(A));
	}

}
