package training.dp;

public class BestTimeBuySellStockII {

	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length ==0) return 0;
		
		int profit = 0;
		for(int i=0;i<prices.length-1;i++) {
			if(prices[i+1] > prices[i])
				profit += prices[i+1] - prices[i];
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7,1,5,3,6,4};
		System.out.println(maxProfit(A));
	}

}
