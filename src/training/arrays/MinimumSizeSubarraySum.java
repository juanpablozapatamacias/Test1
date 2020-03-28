package training.arrays;

public class MinimumSizeSubarraySum {
	
	public static int minSubArrayLen(int s, int[] arr) {
		if(arr.length==1 || arr == null) return 0;
		
		int result = arr.length;
		
		int start = 0;
		int sum = 0;
		int i = 0;
		boolean exists = false;
		
		while(i<=arr.length) {
			if(sum >= s) {
				exists =true;
				if(start==i-1) return 1;
				
				result = Math.min(result, i-start);
				sum = sum - arr[start];
				start++;
			}
			else {
				if(i == arr.length) break;
				
				sum = sum + arr[i];
				i++;
			}
		}
		
		return exists ? result : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,A));
	}

}
