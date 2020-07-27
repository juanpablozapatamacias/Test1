package training.arrays;

public class SearchRotatedSortedArray {
	
	public static int search(int[] a, int target) {
		if(a == null || a.length ==0) return -1;
		
		int left =0;
		int right = a.length -1;
		
		while(left < right) {
			int mid  = left + (right - left) / 2;
			
			if(a[mid] > a[right]) left = mid +1;
			else right = mid;
		
		}
		
		int start = left;
		left=0;
		right = a.length-1;
		
		if (target >= a[start] && target <=a[right]) {
			left = start;
		}
		else {
			right = start;
		}
		
		while(left <=right) {
			int mid  = left + (right - left) / 2;
			if(a[mid] == target) return mid;
			else if (a[mid] < target) left = mid +1;
			else right = mid -1;
		}
		
		return -1;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(search(A,0));
	}

}
