package training.sorting.quicksort.itereativeQS;

public interface QuickSort {

	public void swap(int[] arr, int a, int b);
	
	public int partition(int[] arr, int l, int h);
	
	public void printArray(int[] arr);

	public void quickSort(int[] arr, int i, int j);
}
