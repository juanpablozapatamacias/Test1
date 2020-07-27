package training.searches;

import java.util.Arrays;

public class FindRightInterval {
	
	public static int[] find(int[][] intervals) {
		int[][] starts = new int[intervals.length][2];
		
		for(int i=0;i<starts.length;i++) 
			starts[i] = new int[] {intervals[i][0], i};
		
		Arrays.sort(starts, (a,b)->Integer.compare(a[0], b[0]));
		
		int[] result = new int[intervals.length];
		Arrays.fill(result, -1);
		
		for(int i=0;i<intervals.length;i++) {
			int end = intervals[i][1];
			int l=0,r=starts.length-1;
			
			while(l < r) {
				int mid = l + (r-l) / 2;
				int start = starts[mid][0];
				if (start >= end) r =mid;
				else l = mid +1;
			}
			
			if(starts[l][0] >= end && i != starts[l][1])
				result[i] = starts[l][1];
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,4},{2,3},{3,4}};
		System.out.println(Arrays.toString(find(A)));
	}

}
