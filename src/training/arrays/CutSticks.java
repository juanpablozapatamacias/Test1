package training.arrays;

import java.util.ArrayList;
import java.util.List;

public class CutSticks {

	public static int[] cut(int[] arr) {
		int sticksLeft;
		int curr;
		int currCont = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		quickSort(arr,0,arr.length-1);
		
		sticksLeft = arr.length;
		curr = arr[0];
		
		list.add(arr.length);
		
		for(int i=0;i<arr.length;i++) {
			if(curr==arr[i]) currCont++;
			else {
				sticksLeft -= currCont;
				currCont = 1;
				curr = arr[i];
				list.add(sticksLeft);
			}
		}
		return list.stream().mapToInt(i->i).toArray();
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int temp;
		int middle = arr[(low+high)/2];
		
		while(i<j) {
			while(arr[i] < middle) i++;
			while(arr[j] > middle) j--;
			
			if(i<=j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		if(low<j) quickSort(arr,low,j);
		if(i<high) quickSort(arr,i,high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A= {5,4,4,2,2,8};
		System.out.println(cut(A).toString());

	}

}
