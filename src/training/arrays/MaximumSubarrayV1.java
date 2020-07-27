package training.arrays;

public class MaximumSubarrayV1 {
	
	public static int maxSubarray(int[] arr, int k) {
		if(arr==null || arr.length==0) return -1;
		
		int mSum=0,wSum=0,start=0,end=0;
		
		while(end < k) 
			wSum += arr[end++];
		
		while(end<arr.length) {
			wSum += arr[end++] - arr[start++];
			mSum = Math.max(mSum, wSum);
		}
		
		return mSum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,9,-1,-2,7,3,1,2};
		int k = 4;
		
		System.out.println(maxSubarray(a,k));
	}

}
