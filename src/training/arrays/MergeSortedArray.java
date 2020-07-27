package training.arrays;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void merge(int[] arr1, int m, int[] arr2, int n) {
		int count = m + n -1;
		--m;
		--n;
		while(m >=0 && n>=0) {
			if(arr1[m] > arr2[n]) 
				arr1[count--] = arr1[m--];
			else arr1[count--] = arr2[n--];
		}
		while(n >=0) arr1[count--] = arr2[n--];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,0,0,0};
		int[] b = {2,5,6};
		merge(a,3,b,3);
		System.out.println(Arrays.toString(a));
	}

}
