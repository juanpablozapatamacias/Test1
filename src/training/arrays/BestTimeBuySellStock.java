package training.arrays;

public class BestTimeBuySellStock {
	
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length <=1 ) return 0;
		
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for(int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		
		return maxProfit;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7,1,5,3,6,4};
		System.out.println(maxProfit(A));
	}

}
