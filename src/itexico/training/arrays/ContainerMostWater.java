package itexico.training.arrays;

public class ContainerMostWater {
	
	public static int maxArea(int[] height) {
		if(height == null || height.length < 2) return 0;
		
		int res = 0, left = 0, right = height.length-1;
		
		while(left < right) {
			res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
			if(height[left] < height[right]) ++left;
			else --right;
		}
		
		return res;
	}

	public static void main(String[] arg) {
		int[] A = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(A));
	}
}
