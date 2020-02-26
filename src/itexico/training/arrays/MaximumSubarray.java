package itexico.training.arrays;

public class MaximumSubarray {
	
	public static int maxSubArray(int[] arr,int left,int right) {
	
		int mid; 
		int leftMax,rightMax;
		int sum;
		int maxLeftRight;
		
		if(right == left) return arr[left];
		
		mid = (left + right) >> 1;
		
		leftMax = Integer.MIN_VALUE;
		sum = 0;
		for (int i=mid;i>=left;i--) {
			sum += arr[i];
			if (sum > leftMax) leftMax = sum;
		}
		
		rightMax = Integer.MIN_VALUE;
		sum = 0;
		for (int i=mid+1;i<=right;i++) {
			sum+=arr[i];
			if (sum > rightMax) rightMax = sum;
		}
		
		maxLeftRight = Integer.max(maxSubArray(arr,left,mid), maxSubArray(arr,mid+1,right));
		
		return Integer.max(maxLeftRight, leftMax+rightMax);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, -4, 1, 9, -6, 7, -3};
		System.out.println(maxSubArray(A,0,A.length-1));
	}

}
