package training.searches;

import java.util.Arrays;

public class KokoEatingBananas {
	
	public static int minEatingSpeed(int[] piles, int H) {
		int left = 1;
		int right = Arrays.stream(piles).max().getAsInt();
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(canEatInTime(piles, mid,H)) right = mid-1;
			else left = mid +1;
			
		}
		return left;
	}
	
	public static boolean canEatInTime(int []piles, int K, int H) {
		int hrs = 0;
		
		for (int pile:piles) {
			int div = pile / K;
			hrs += div;
			if(pile % K != 0) ++hrs;
		}
		
		return hrs <= H;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
