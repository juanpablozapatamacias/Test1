package training.arrays;

import java.util.List;
import java.util.ArrayList;

public class CombinationSumII {
	
	public static List<List<Integer>> combination(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<>();
		merge(candidates);
		
		findCombinations(candidates,0,target,new ArrayList<Integer>(),res);
		
		return res;
	}
	
	private static void findCombinations(int[] candidates, int index, int target, List<Integer> current,
			List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if(target==0) {
			res.add(new ArrayList<>(current));
			return;
		}
		
		if(target <0) return;
		
		for(int i=index;i<candidates.length;i++) {
			if(i>index && candidates[i] == candidates[i-1]) {
				continue;
			}
			current.add(candidates[i]);
			findCombinations(candidates, i + 1, target-candidates[i],current, res);
			current.remove(current.size()-1);
			
		}
	}

	public static void merge(int[] arr) {
		int n=arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<r.length) {
				if(l[i]<=r[j]) arr[k++] = l[i++];
				else arr[k++]=r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{10,1,2,7,6,1,5};
        int tagetSum = 8;
        
        System.out.println(combination(arr,tagetSum));
	}

}
