package itexico.training.sorting.mergesort;

import java.util.Arrays;

public class AppMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeSort ms = new MergeSortAlgorithm();
		int[] arr = {66,33,40,22,88,55,77,44,30,60,11,80,20,50};
		ms.mergeSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Another MergeSort variant that return a long value");
		int[] arr1 = {2,1,3,1,2};
		ms.mergeSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		
		int[] arr2 = {2, 1, 1, 2, 3, 4, 3, 4, 5, 6, 5, 6, 7, 7, 3};
		ms.mergeSort(arr2);
		System.out.println(Arrays.toString(arr2));
		
	}

}
