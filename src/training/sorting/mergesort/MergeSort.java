package training.sorting.mergesort;

public interface MergeSort {

	public void merge(int[] arr, int[] l, int[] r, int left, int right);
	public void mergeSort(int[] arr, int n);
	
	public void mergeSort(int[] arr);
	
	//public long mergeSort1(int[] arr, int n);
	//public long merge1(int[] arr, int[] l, int[] r, int left, int right);
	
	//public long merge(int[] arr, int[] aux, int low, int mid, int high);
	//public long mergeSort(int[] arr, int[] aux, int low, int high);
}
