package training;

public class ContainerMostWater {

	public static int maxArea(int[] height) {
		if(height == null || height.length < 2) return 0;
		
		int max = 0, left=0, right = height.length - 1;
		
		while(left < right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			
			if(height[left] < height[right]) left++;
			else right--;
		}
		
		return max;
	}
	
	public static int trap(int[] height) {
		if(height == null) return 0;
		
		int result = 0,left_max = 0, right_max=0;
		
		int lo = 0, hi = height.length - 1;
		
		while(lo <= hi) {
			if(height[lo] < height[hi]) {
				if(height[lo] > left_max) left_max = height[lo];
				else result += left_max - height[lo];
				
				lo++;
			}
			else {
				if(height[hi] > right_max) right_max = height[hi];
				else result += right_max - height[hi];
				
				hi--;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] arg) {
		int[] a = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
		
		System.out.println(maxArea(a));
		System.out.println(trap(a));
	}
}
