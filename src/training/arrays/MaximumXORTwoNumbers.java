package training.arrays;

import java.util.HashSet;

public class MaximumXORTwoNumbers {
	
	public static int findMaximum(int[] arr) {
		int maxx=0, mask=0;
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=30; i>=0; i--) {
			mask |= (1<<i);
			
			for (int j=0; j<arr.length; ++j) {
				set.add(arr[j] & mask);
			}
			
			int newMax = maxx | (1 << i);
			
			for(int prefix : set) {
				if(set.contains(newMax ^ prefix)) {
					maxx = newMax;
					break;
				}
			}
			
			set.clear();
		}
		return maxx;
	}
	
	public static void main(String[] arg) {
		int[] A = {25,10,2,8,5,3};
		System.out.println(findMaximum(A));
	}

}
