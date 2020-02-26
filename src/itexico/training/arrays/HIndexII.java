package itexico.training.arrays;

public class HIndexII {
	
	public static int index(int[] citations) {
		if(citations == null || citations.length==0) return 0;
		
		int n = citations.length;
		int start = 0;
		int end = n -1;
		int mid;
		
		while(start <= end) {
			mid = start + (end-start) / 2;
			
			if(citations[mid] == n - mid) return citations[mid];
			else if(citations[mid] < n - mid) start = mid + 1;
			else end = mid -1;
		}
		
		return n-end-1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,3,5,6};
		System.out.println(index(A));
	}

}
