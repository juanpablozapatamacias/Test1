package training.searches;

public class SumMutatedArrayClosestTarget {
	
	public static int findBestValue(int[] arr, int target) {
		int diff = Integer.MAX_VALUE;
		int value = Integer.MAX_VALUE;
		
		merge(arr);
		
		int left = 0;
		int right = arr[arr.length-1];
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			int tempDiff = findDifference(arr,target,mid);
			int tempValue = mid;
			
			if(tempDiff > 0)
				left = mid +1;
			else
				right = mid -1;
			
			tempDiff = Math.abs(tempDiff);
			
			if(tempDiff < diff) {
				diff = tempDiff;
				value = tempValue;
			}
			else if(tempDiff == diff){
				value = (tempValue < value) ? tempValue : value;
			}
		}
		
		return value;
		
	}
	
	public static int max(int[] arr) {
		int max = 0;
		
		for (int num : arr) {
			if(num > max) max = num;
		}
		
		return max;
	} 
	
	public static int findDifference(int[] arr, int target, int val) {
		int sum =0;
		
		for (int num : arr) 
			sum += (num > val) ? val:num;
		
		return target - sum;
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if (n >1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i<l.length && j<r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i<l.length) arr[k++] = l[i++];
			while(j<r.length) arr[k++] = r[j++];
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,5};
		int target =10;
		
		System.out.println(findBestValue(A,target));
	}

}
