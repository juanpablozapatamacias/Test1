package itexico.training.sorting.quicksort.itereativeQS;

public class AppIterativeQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort qs = new IterativeQuickSort();
		int[] arr = {6,4,9,10,3};
		
		qs.quickSort(arr,0,arr.length-1);
		qs.printArray(arr);
		
	}

}
