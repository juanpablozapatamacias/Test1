package itexico.training.sorting.selectionsort;

public class Selection {
	
	public static void print(int[] listToSort) {
		for(int el : listToSort) {
			System.out.print(el + ", ");
		}
		System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					swap(arr,i,j);
					print(arr);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {66,4,90,7,10,99};
		selectionSort(A);
	}

}
