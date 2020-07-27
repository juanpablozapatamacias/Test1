package training.arrays;

public class MedianTwoSortedArrays {

	public static void merge(int[] arr) {
		int n=arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		
		if(n>1) {
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
	
	public static int[] merge(int[] l, int[] r) {
		int [] arr = new int[l.length+r.length];
		int n= arr.length;
		
		int i=0,j=0,k=0;
		
		while(i<l.length && j<r.length) {
			if(l[i] <= r[j]) arr[k++] = l[i++];
			else arr[k++] = r[j++];
		}
		
		while(i<l.length) arr[k++] = l[i++];
		while(j<r.length) arr[k++] = r[j++];
		
		
		return arr;
	}
	
	public static int[] joinArrays(int[] a, int [] b) {
		int len = a.length + b.length;
		int[] res = new int[len];
		int count=0;
		
		for(int a1 : a)
			res[count++] = a1;
		
		for(int b1: b)
			res[count++] = b1;
		
		
		return res;
	}
	
	public static double findMedianArray(int[] a1, int[] a2) {
		//if(a1 == null || a2 == null || a1.length == 0 || a2.length == 0) return 0.0;
		double median;
		
		//int[] arrMedian = joinArrays(a1, a2);
		int[] arrMedian = merge(a1,a2);
		int totalElements = arrMedian.length;
		
		//merge(arrMedian);
		
		if(totalElements %2 == 0) {
			int sumMiddle = arrMedian[totalElements / 2] + arrMedian[(totalElements /2) - 1];
			median = ((double) sumMiddle) / 2;
		}
		else
			median = (double)arrMedian[totalElements / 2];
		
		return median;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {};
		int[] b = {1};
		
		System.out.println(findMedianArray(a,b));
	}

}
