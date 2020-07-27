package training.arrays;

public class MedianTwoSortedArraysV2 {

	public static double median(int[] a1, int[] a2) {
		if(a1.length > a2.length) return median(a2, a1);
		
		int x = a1.length;
		int y = a2.length;
		
		int low =0;
		int high = x;
		
		while(low <=high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x+y+1)/2 - partitionX;
			
			int maxLeftX = (partitionX ==0) ? Integer.MIN_VALUE : a1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : a2[partitionY -1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : a2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((x+y) % 2 == 0) return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				else return ((double)Math.max(maxLeftX, maxLeftY));
			}
			else if(maxLeftX > minRightY) high = partitionX - 1;
			else low = partitionX + 1;
		}
		
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		int[] x = {1, 2};
        int[] y = {3, 4};

        System.out.println(median(x,y));
	}
	
}
