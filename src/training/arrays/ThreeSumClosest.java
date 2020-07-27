package training.arrays;

public class ThreeSumClosest {
	
	public static int sum(int[] nums, int target) {
		if(nums.length==0 || nums == null)
			throw new IllegalArgumentException("Invalid input");
		
		merge(nums);
		int closest = nums[0] + nums[1] + nums[2];
		
		for(int i=0;i<nums.length;i++) {
			int left = i+1;
			int right = nums.length-1;
			
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if(Math.abs(sum - target) < Math.abs(closest - target))
					closest = sum;
				if (sum==target) return sum;
				else if (sum < target) ++left;
				else --right;
			}
		}
		return closest;
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if (n>1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while (i<l.length) arr[k++] = l[i++];
			while (j<r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-1,2,1,-4};
		System.out.println(sum(A,1));
	}

}
