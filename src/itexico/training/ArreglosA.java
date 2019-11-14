package itexico.training;

import java.util.Arrays;

public class ArreglosA {
	
	public static void countNegNumbersArray(int [][] ar) {
		int rows = ar.length;
		int cols = ar[0].length;
		int count = 0;
		
		for(int i=0; i<rows; i++) {
			//Arrays.sort(ar[i]);
			sort(ar[i],0,cols-1);
			
			for(int j=0; j<cols; j++) {
				if(ar[i][j] < 0) {
					count++;
				} 
				else break;
			}
		}
		System.out.println("Cantidad de numeros negativos: " + count);
	}
	
	
	
	public static void main(String[] args) {
		int [][] arre = {{3,-2,-1,1,2,6},
						 {2,-2,0,1,4,6},
						 {5,-9,1,2,3,4},
						 {1,-10,-9,-8,-1,0},
						 {5,2,4,-5,0,1}
						};
		countNegNumbersArray(arre);
	}
	
	static int partition(int arr[], int low, int high) {
		
		int pivot = arr[high];
		int i = (low -1);
		for(int j=low;j<high;j++) {
			if(arr[j] < pivot) {
				i++;
				
				int temp=arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;
	}
	
	public static void sort(int arr[],int low, int high) {
		if(low < high) {
			int pi = partition (arr,low,high);
			
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}

}
