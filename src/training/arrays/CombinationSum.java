package training.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public static List<List<Integer>> combination(int[] candidates, int target){
		if(candidates==null) return null;
		
		List<List<Integer>> res = new ArrayList<>();
		
		findCombinations(candidates, 0, target, new ArrayList<>(), res);
		
		return res;
	}

	private static void findCombinations(int[] candidates, int index, int target, List<Integer> current,
			List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if(target==0) {
			res.add(new ArrayList<>(current));
			return;
		}
		
		for(int i=index;i<candidates.length; i++) {
			if(candidates[i] <= target) {
				current.add(candidates[i]);
				findCombinations(candidates, i, target-candidates[i], current, res);
				current.remove(new Integer(candidates[i]));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A= {2,3,6,7};
		int target = 7;
		
		System.out.println(combination(A,7));
	}

}
