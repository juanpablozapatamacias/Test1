package training.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static List<List<Integer>> sum(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		
		merge(nums);
		//Arrays.sort(nums);
		
		for(int i=0;i<nums.length;++i) {
			int left = i+1;
			int right = nums.length-1;
			
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum ==0) {
					List<Integer> tem = new ArrayList<>();
					tem.add(nums[i]);
					tem.add(nums[left]);
					tem.add(nums[right]);
					res.add(tem);
					
					int leftValue = nums[left];
					while(left < nums.length && nums[left] == leftValue) 
						++left;
					
					int rightValue = nums[right];
					while(right > left && nums[right] ==  rightValue) 
						--right;	
				}
				else if(sum < 0) ++left;
				
				else --right;
			}
			
			while(i+1 < nums.length && nums[i] == nums[i+1]) 
				++i;
		}
		return res;
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n-mid;
		
		int[] l = new int [mid];
		int[] r = new int [range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i]=arr[i];
			for(int j=mid;j<n;j++) r[j-mid]=arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <=r[j]) arr[k++] = l[i++];
				else arr[k++]=r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-1,0,1,2,-1,4};
		System.out.println(sum(A));
	}

}
