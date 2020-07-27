package training.searches;

public class MinNumDaysMakeBouquets {
	
	public static int minDays(int[] bloomDay, int m, int k) {
		if(bloomDay.length == 0 || m==0 || k==0) return 0;
		if(m*k > bloomDay.length) return -1;
		
		int l = Integer.MAX_VALUE;
		int r = Integer.MIN_VALUE;
		
		for(int i=0;i<bloomDay.length;i++) {
			l = Math.min(l, bloomDay[i]);
			r = Math.max(r, bloomDay[i]);
		}
		
		while(l <= r) {
			int mid = l + (r-l)/2;
			
			if(isValid(bloomDay,m,k,mid)) {
				r = mid -1;
			}
			else l=mid + 1;
		}
		
		return l;
	}
	
	public static boolean isValid(int[] bloomDay, int m, int k, int mid) {
		int count=0,size=0;
		for(int i=0;i<bloomDay.length;i++) {
			size = (bloomDay[i] <= mid) ? size + 1 : 0;
			
			if(size == k) {
				size=0; 
				count++;
			}
			if(count == m) return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,10,3,10,2};
		
		System.out.println(minDays(A,3,1));
	}

}
