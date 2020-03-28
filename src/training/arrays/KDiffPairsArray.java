package training.arrays;

import java.util.HashMap;
import java.util.Map;

class Pair{
	int a, b;
	public Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}

public class KDiffPairsArray {
	
	public static int findPairsMap(int[] nums, int k) {
		Map<Integer,Pair> map =  new HashMap<>();
		
		for (int i=0;i<nums.length;i++) {
			for (int j=0;j<nums.length;j++) {
				if(i==j) continue;
				if(Math.abs(nums[i] - nums[j]) == k) {
					
					Pair p = nums[i] < nums[j] ? new Pair(nums[i], nums[j]) :  new Pair(nums[j], nums[i]);
					
					if(nums[i] < nums[j]) {
						map.put(nums[i]*10+nums[j],p);
					}
					else {
						map.put(nums[j]*10+nums[i],p);
					}
				}
			}
		}
		
		return map.size();
	}
	
	public static int findPairsBinarySearch(int[] nums, int k) {
		int count = 0;
		int len = 0;
		
		merge(nums);
		len = removeDuplicates(nums);
		
		for(int i=0;i<nums.length-1;i++) {
			if(binarySearch(nums,i+1,nums.length-1,nums[i]+k) != -1) 
				count++;
		}
		
		return count;
	}
	
	public static int findPairsSorting(int[] nums, int k) {
		int count = 0;
		int l=0,r=0;
		merge(nums);
		
		while(r < nums.length) {
			if(Math.abs(nums[r] - nums[l]) == k) {
				count++;
				l++;
				r++;
			}
			else if (nums[r] - nums[l] > k) l++;
			else r++;
		}
		
		return count;
		
	}
	
	private static int binarySearch(int[] nums, int low, int high, int k) {
		// TODO Auto-generated method stub
		if(high >= low) {
			int mid = low + (high - low) /2;
			if(k==nums[mid]) return mid;
			else if(k < nums[mid]) return binarySearch(nums,low,mid-1,k);
			else return binarySearch(nums, mid+1,high,k);
		}
		return -1;
	}

	private static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n > 1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
			
		}
	}
	
	private static int removeDuplicates(int[] arr) {
		int n = arr.length;
		int j=0;
		
		if(n==0 || n==1) return n;
		
		for (int i=0;i<n-1;i++) {
			if(arr[i] != arr[i+1]) arr[j++] = arr[i];
		}
		
		arr[j++]=arr[n-1];
		
		return j;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,1,5,4};
		int k = 0;
		
		System.out.println(findPairsMap(A,k));
		System.out.println(findPairsBinarySearch(A,k));
		System.out.println(findPairsSorting(A,k));
	}

}
