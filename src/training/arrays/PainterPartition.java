package training.arrays;

public class PainterPartition {
	
	private static int getMax(int[] arr) {
		int max = arr[0];
		
		for(int i=0;i<arr.length-1;i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		return max;
	}
	
	private static int getSum(int[] arr) {
		int sum=0;
		
		for (int i=0;i<arr.length-1;i++) 
			sum += arr[i];
		
		return sum;
	}
	
	public static int partition(int[] arr) {
		return 0;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
