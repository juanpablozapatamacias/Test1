package training.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	
	public static List<Integer> divisible(int[] nums){
		List<Integer> res = new ArrayList<>();
		
		if(nums==null ||nums.length==0) return res;
		
		merge(nums);
		
		int[] t = new int[nums.length];
		int[] index = new int[nums.length];
		
		Arrays.fill(t,1);
		Arrays.fill(index, -1);
		
		int max =0;
		int maxIndex = -1;
		
		for(int i=0;i<t.length;i++) {
			for(int j=i-1;j>=0;j--) {
				if(nums[i] % nums[j] == 0 && t[j]+1 > t[i]) {
					t[i] = t[j] +1;
					index[i] = j;
				}
			}
			
			if(max < t[i]) {
				max=t[i];
				maxIndex = i;
			}
		}
		
		int i = maxIndex;
		while(i >= 0) {
			res.add(nums[i]);
			i=index[i];
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
			
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length)arr[k++] = l[i++];
			while(j<r.length)arr[k++] = r[j++];
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		System.out.println(divisible(A));
	}

}
