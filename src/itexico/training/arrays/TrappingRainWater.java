package itexico.training.arrays;

public class TrappingRainWater {
	
	public static int trap(int[] height) {
		if(height == null || height.length == 0) return 0;
		
		int left = 0;
		int right = height.length - 1;
		int res = 0, level=0;
		
		
		while(left < right) {
			int lower = height[ height[left] < height[right] ? left++ : right--];
			level = Math.max(level, lower);
			res += level - lower;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}

}
