package training.bigO.divideconquer;

import java.util.Arrays;

public class CountingInversions {

	public static long countInversions(int[] arr) {
		int n = arr.length;
		long count = 0;
		
		if (n<2) return 0;
		
		int mid = n / 2;
		int range = n-mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		int iLeft = 0;
		int iRight = 0;
		
		for (int i=0;i<mid;i++)
			l[i] = arr[i];
		
		for (int j=mid;j<n;j++)
			r[j-mid] = arr[j];
		
		count = countInversions(l) + countInversions(r);
		
		for(int i=0;i<n;i++) {
			if(iLeft < mid && (iRight >= range || l[iLeft] <= r[iRight])) {
				arr[i] = l[iLeft++];
				count += iRight;
			}
			else if(iRight < range) {
				arr[i] = r[iRight++];
			}
		}
		
		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{2,1,3,1,2};
		long inv = countInversions(arr);
		System.out.println(inv);
		System.out.println(Arrays.toString(arr));

	}

}
