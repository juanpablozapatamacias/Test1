package training.arrays;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
	
	public static boolean canPartition(int[] nums) {
		int total = 0;
		
		for(int i : nums) 
			total += i;
		
		if(total % 2 != 0) return false;
		
		return canPartition(nums, 0,0,total, new HashMap<String,Boolean>());		
	}

	private static boolean canPartition(int[] nums, int index, int sum, int total, Map<String,Boolean> state) {
		// TODO Auto-generated method stub
		String current = index + "" + sum;
		
		if(state.containsKey(current)) return state.get(current);
		
		if(sum * 2 == total) return true;
		if(sum > total / 2 || index >= nums.length) return false;
		
		boolean foundPartition = canPartition(nums, index +1,sum, total,state) 
				|| canPartition(nums, index+1, sum + nums[index], total,state);
		
		state.put(current, foundPartition);
		return foundPartition;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,11,5};
		System.out.println(canPartition(a));
	}

}
