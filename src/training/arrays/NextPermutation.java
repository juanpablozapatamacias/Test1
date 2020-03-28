package training.arrays;

import java.util.Arrays;

public class NextPermutation {
	
	public static void permutation(int[] nums) {
		int mark = -1;
		int idx;
		
		for(int i=nums.length-1;i>0;i--) {
			if(nums[i] > nums[i-1]) {
				mark = i-1;
				break;
			}
		}
		
		if(mark == -1) {
			reverse(nums,0,nums.length-1);
			return;
		}
		
		idx = nums.length-1;
		
		for(int i=nums.length-1;i >= mark+1;i--) {
			if(nums[i] > nums[mark]) {
				idx = i;
				break;
			}
		}
		
		swap(nums,mark,idx);
		reverse(nums,mark+1,nums.length-1);
	}

	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void reverse(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		while(i<j) {
			swap(nums,i,j);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,3,2,1};
		permutation(A);
		System.out.println(Arrays.toString(A));
	}

}
