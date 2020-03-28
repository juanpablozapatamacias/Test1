package training.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClimbingLeaderboard {
	
	public static int[] climbing(int[] scores, int[] alice) {
		
		HashSet<Integer> hs = new HashSet<>();
		int[] arr;
		int[] aliceRank;
		
		for(int i =0;i<scores.length;i++) {
			hs.add(scores[i]);
		}
		
		arr = hs.stream().mapToInt(i->i).toArray();
		
		quickSort(arr,0,arr.length-1);
		
		aliceRank = new int[alice.length];
		
		for (int j=0;j<alice.length;j++) {
			aliceRank[j] = binarySearch(arr,0,arr.length,alice[j]);
			System.out.println(aliceRank[j]);
		}
		
		return aliceRank;
		
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		int i=low;
		int j=high;
		int temp;
		int mid = arr[(low+high)/2];
		
		while(i<j) {
			while (arr[i] > mid) i++;
			while (arr[j] < mid) j--;
			
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

	private static int binarySearch(int[] arr, int start, int end, int x) {
		int half = (start + end) / 2;
		
		if(start >= arr.length) return arr.length + 1;
		if(end < start) return start+1;
		
		if(x > arr[half]) return binarySearch(arr,start,half-1,x);
		else if(x < arr[half]) return binarySearch(arr,half+1,end,x);
		else return half + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {100,90,90,80,75,60};
		int[] alice = {50,65,77,90,102};
		
		int[] res = climbing(scores,alice);
	}

}
