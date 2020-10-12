package training.searches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Item{
	int val;
	int index;
	
	public Item( int val, int in) {
		this.val =val;
		this.index = in;
		
	}
}

public class CountSmallerNumbersAfterSelf {

	public static List<Integer> count(int[] nums){
		List<Integer> res = new ArrayList<>();
		
		if(nums==null || nums.length == 0) return res;
		int n = nums.length;
		
		Item[] items = new Item[n];
		
		for(int i=0;i<n;i++) {
			items[i] = new Item(nums[i],i);
		}
		
		int[] count = new int[n];
		
		mergeSort(items,0,n-1,count);
		
		for (int c : count)
			res.add(c);
		
		return res;
	}
	
	
	
	private static void mergeSort(Item[] items, int lo, int hi, int[] count) {
		// TODO Auto-generated method stub
		if(lo >= hi) return;
		int mid = lo + (hi - lo) /2;
		
		mergeSort(items,lo,mid,count);
		mergeSort(items,mid+1,hi,count);
		merge(items,lo,mid,mid+1,hi,count);
	}

	private static void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {
		// TODO Auto-generated method stub
		int m = hiEnd - lo +1;
		Item[] sorted = new Item[m];
		int index = 0;
		int loPtr = lo, hiPtr=hi;
		
		int rightCounter = 0;
		
		while(loPtr <= loEnd && hiPtr <= hiEnd) {
			if(items[hiPtr].val <  items[loPtr].val) {
				rightCounter++;
				sorted[index++] = items[hiPtr++];
			}
			else {
				count[items[loPtr].index] += rightCounter;
				sorted[index++] = items[loPtr++];
			}
		}
		
		while(loPtr <= loEnd) {
			count[items[loPtr].index] += rightCounter;
			sorted[index++] = items[loPtr++];
		}
		
		while(hiPtr <= hiEnd) {
			sorted[index++] = items[hiPtr++];
		}
		
		System.arraycopy(sorted, 0, items, lo, m);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,2,6,1};
		System.out.println(count(A));
	}

}
