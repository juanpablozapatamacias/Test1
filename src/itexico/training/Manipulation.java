package itexico.training;

public class Manipulation {
	static long arrayManipulation(int n, int[][] queries) {
		long outputArray[] = new long[n+2];
		for(int i=0;i<queries.length;i++) {
			int a = queries[i][0];
			int b = queries[i][1];
			int k = queries[i][2];
			outputArray[a] += k;
			outputArray[b+1] -= k;
			
		}
		long max = getMax(outputArray);
		return max;
	}

	public static long getMax(long[] inputArray) {
		// TODO Auto-generated method stub
		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i=0;i<inputArray.length;i++) {
			sum += inputArray[i];
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public static void main(String[] arg) {
		int[][] q = {{1,2,100},
					 {2,5,100},
					 {3,4,100}};
		System.out.println(arrayManipulation(5,q));
		
	}

}
