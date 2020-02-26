package itexico.training.arrays;

public class PeakIndexMountain {
	
	public static int peakIndexMountainArray(int[] arr) {
		if(arr.length < 3) return -1;
		
		int left = 0;
		int right = arr.length-1;
		int mid;
		
		while(left < right) {
			mid = (left+right) / 2;
			if(arr[mid] >= arr[mid+1]) right = mid;
			else left=mid+1;
		}
		return left;
	}

	public static void main(String[] args) {
		int[] A = {0,2,1,0};
		System.out.println(peakIndexMountainArray(A));
	}

}
