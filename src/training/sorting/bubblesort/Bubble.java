package training.sorting.bubblesort;

public class Bubble {
	
	public static void print(int[] arr) {
		for(int el : arr) {
			System.out.print(el + ", ");
		}
		System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			boolean swapped= false;
			for (int j=arr.length-1;j>i;j--) {
				if(arr[j] < arr[j-1]) {
					swap(arr,j,j-1);
					swapped = true;
				}
				print(arr);
			}
			
			if(!swapped) break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7,99,2,9,6,5,1,10};
		
		bubbleSort(A);
	}

}
