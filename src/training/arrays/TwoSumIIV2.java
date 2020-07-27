package training.arrays;

import java.util.Arrays;

public class TwoSumIIV2 {

	public static int[] twoSum(int[] nums, int target) {
		int start=0;
		int end = nums.length-1;
		int[] res = new int[2];
		
		while(start < end) {
			int sum=nums[start] + nums[end];
			if(sum == target) {
				res[0] = start + 1;
				res[1] = end + 1;
				break;
			}
			else if(sum < target)
				start++;
			else 
				end--;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,7,8,11};
		int target = 15;
		System.out.println(Arrays.toString(twoSum(a,target)));
	}

}
