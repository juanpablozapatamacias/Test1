package training.searches;

public class CapacityShipPackagesDays {
	
	public static int shipWithinDays(int[] weights, int D) {
		int min = 0;
		int max = 0;
		
		for (int w: weights) {
			min=Math.max(w, min);
			max += w; 
		}
		
		int retVal = 0;
		while(min <= max) {
			int mid = min + (max - min) / 2;
			int daysRequired = numberDaysNeededCapacity(weights,mid);
			
			if(daysRequired > D) {
				min = mid + 1;
			}
			else {
				retVal = mid;
				max = mid -1;
			}
		}
		
		return retVal;
	}

	private static int numberDaysNeededCapacity(int[] weights, int capacity) {
		int daysRequired = 1;
		int current = 0;
		
		for(int w : weights) {
			current +=w;
			if (current > capacity) {
				daysRequired++;
				current = w;
			}
		}
		
		return daysRequired;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {3,2,2,4,1,4};
		System.out.println(shipWithinDays(A,3));
	}

}
