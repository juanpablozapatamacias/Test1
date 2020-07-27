package training.dp;

public class DeleteEarn {
	
	public static int delete(int[] nums) {
		if(nums.length ==0 || nums == null) return 0;
		int max =0;
		
		merge(nums);
		/*
		for(int num : nums) {
			max = Math.max(num, max);
		}*/
		max = nums[nums.length-1];
		
		if(max == 1) return nums.length;
		int[] dp = new int[max + 1];
		
		for(int num : nums) 
			dp[num] += num;
		
		dp[dp.length-2] = Math.max(dp[dp.length-2], dp[dp.length-1]);
		
		for(int i = dp.length-3;i>=0;i--)
			dp[i] = Math.max(dp[i+1], dp[i] + dp[i+2]);
		
		return dp[0];
		
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j <r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,4,2};
		System.out.println(delete(A));
	}

}
