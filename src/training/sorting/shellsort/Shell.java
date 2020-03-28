package training.sorting.shellsort;

public class Shell {
	
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
	
	public static void insertionSort(int[] arr, int startIndex, int increment) {
		for(int i=startIndex;i<arr.length;i = i+ increment) {
			for(int j = Math.min(i + increment, arr.length-1);
				j-increment >=0; 
				j = j-increment) {
				if(arr[j] < arr[j-increment]) swap(arr,j,j-increment);
				else break;
				
				print (arr);
			}
		}
	}
	
	public static void shellSort(int[] arr) {
		int increment = arr.length / 2;
		while(increment >=1 ) {
			for(int i=0;i<increment;i++) 
				insertionSort(arr,i,increment);
		}
		increment = increment / 2;
	}

	public static void main(String[] args) {
		int[] A = {7,8,2,9,6,5,1,10,4,3};
		
		shellSort(A);
	}

}
