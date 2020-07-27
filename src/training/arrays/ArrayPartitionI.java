package training.arrays;

public class ArrayPartitionI {
	
	public static int arrayPairSum(int[] nums) {
		int sum = 0;
		
		merge(nums);
		
		for(int i=0;i<nums.length-1;i+=2) {
			sum += nums[i];
		}
		
		return sum;
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int l[] = new int[mid];
		int r[] = new int[range];
		
		if(n>1) {
			for (int i=0;i<mid;i++) l[i] = arr[i];
			for (int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,3,2};
		System.out.println(arrayPairSum(A));
	}

}
