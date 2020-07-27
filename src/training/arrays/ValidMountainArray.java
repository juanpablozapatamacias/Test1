package training.arrays;

public class ValidMountainArray {
	
	public static boolean valid(int[] nums) {
		if(nums == null || nums.length ==0) return false;
		if(nums.length < 3) return false;
		
		int left= 0;
		int right = nums.length -1;
		
		while(left < right && left+1 < nums.length && nums[left] < nums[left+1]) {
			left++;
		}
		
		if(left ==0 || left +1 >= nums.length) return false; 
		
		while(left < right && left+1 < nums.length ) {
			if(nums[left] <= nums[left++ +1]) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,3,4,2,1};
		System.out.println(valid(A));
	}

}
