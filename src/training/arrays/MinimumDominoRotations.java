package training.arrays;

public class MinimumDominoRotations {

	public static int minRotations(int[] A, int[] B) {
	
		int minSwaps = Math.min(
					numSwaps(A[0], A,B),
					numSwaps(B[0], A,B)
				);
		
		minSwaps = Math.min(minSwaps, numSwaps(A[0], B,A));
		minSwaps = Math.min(minSwaps, numSwaps(B[0], B,A));
		
		return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
	}
	
	private static int numSwaps(int target, int[] A, int[] B) {
		// TODO Auto-generated method stub
		
		int numSwaps = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i] != target && B[i] != target) return Integer.MAX_VALUE;
			else if (A[i] != target) numSwaps++; 
		}
		
		return numSwaps;
	}

	public static void main (String[] argv) {
		int[] A = {2,1,2,4,2,2};
		int[] B = {5,2,6,2,3,2};
		
		System.out.println(minRotations(A,B));
	}
}
