package training;

public class HurdleRace {

	public static int hr(int k,int[] height) {
		int largest;
		
		largest = height[0];
		
		for(int i=0;i<height.length;i++) {
			if(largest < height[i]) largest = height[i];
		} 
		
		if(largest > k) return Math.abs(largest - k);
		else return 0;
	}
	
	public static void main(String[] args) {
		int[] h = {1,6,3,5,2};
		System.out.println(hr(4,h));
	}
}
