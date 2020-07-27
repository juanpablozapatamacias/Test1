package training.searches;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestsElements {
	
	public static List<Integer> find(int[] arr, int k, int x){
		int left = 0;
		int right = arr.length - k;
		
		
		while(left < right) {
			int mid = (left + right) / 2;
			int cand = arr[mid];
			
			if(x - arr[mid+k] <= cand - x) right = mid;
			else left =  mid +1;
		}
		
		List<Integer> ans = new ArrayList<>();
		
		int y = left + k;
		while (left < y) {
			ans.add(arr[left]);
			left++;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5};
		int k=4, x=-1;
		
		System.out.println(find(A,k,x));
	}

}
