package training.arrays;

import java.util.List;
import java.util.ArrayList;

public class FourSum {
	
	public static List<List<Integer>> sum(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<>();
		
		if(nums == null || nums.length==0) return res;
		
		merge(nums);
		int size = nums.length;
		
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				int left = j+1;
				int right = size -1;
				
				while(left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					
					if(sum == target) {
						List<Integer> l = new ArrayList<>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[left]);
						l.add(nums[right]);
						res.add(l);
						
						int leftValue = nums[left];
						while(left < size && nums[left] == leftValue) 
							++left;
						
						int rightValue = nums[right];
						while(right > left && nums[right] ==  rightValue) 
							--right;
					} 
					else if(sum < target) 
						++left;
					else 
						--right;
				}
				
				while(j+1 < size && nums[j+1] == nums[j]) 
					++j;
			}
			while(i+1 < size && nums[i+1] == nums[i]) 
				++i;
		}
		return res;
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,0,-1,0,-2,2};
		System.out.println(sum(A,0));
	}

}
