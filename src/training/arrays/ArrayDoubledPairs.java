package training.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayDoubledPairs {
	
	public static boolean canReorderDoubled(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : A) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
	
		Integer[] B =  new Integer[A.length];
		
		for(int i=0;i<A.length;i++) {
			B[i] = A[i];
		}
		
		Arrays.sort(B, Comparator.comparingInt(Math::abs));
		
		for(int num : B) {
			if(map.get(num) == 0) continue;
			if(map.getOrDefault(2 * num, 0) <= 0) {
				return false;
			}
			
			map.put(2*num, map.get(2 * num) - 1);
			map.put(num, map.get(num) - 1);
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,-2,2,-4};
		System.out.println(canReorderDoubled(A));
	}

}
