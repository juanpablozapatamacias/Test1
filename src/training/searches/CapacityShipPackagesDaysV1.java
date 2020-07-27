package training.searches;

public class CapacityShipPackagesDaysV1 {

	public static int sum(int[] arr) {
		int res = 0;
		
		for(int num : arr) res += num;
		
		return res;
	}
	
	public static int max(int[] arr) {
		int max = 0;
		
		for (int num : arr) {
			if(num > max) max = num;
		}
		
		return max;
	} 
	
	public static int shipWithinDays(int[] weights, int D) {
		int low = max(weights);
		int high = sum(weights);
		
		while (low < high) {
			int mid = (low+high) >> 1;
			int partition = 0, sw =0;
			
			for(int num : weights) {
				sw += num;
				
				if(sw > mid) {
					partition +=1;
					sw = num;
				}
			}
			
			if(partition + 1 <= D) high = mid;
			else low = mid+1;
		}
		
		return low;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {3,2,2,4,1,4};
		System.out.println(shipWithinDays(A,3));
	}
	
}
