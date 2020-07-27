package training.arrays;

public class LastStoneWeightV2 {
	
	public static int weight(int[] stones) {
		if(stones.length == 1) return stones[0];
	
		merge(stones);
		
		int len = stones.length;
		int xStoneIdx = len - 2;
		int yStoneIdx = len - 1;
		boolean iterate = true;
		
		while(iterate) {
			int xStoneWeight = stones[xStoneIdx];
			int yStoneWeight = stones[yStoneIdx];
			int resultWeight = yStoneWeight - xStoneWeight;
			
			stones[yStoneIdx] = resultWeight;
			stones[xStoneIdx] = 0;
			
			merge(stones);
			
			if(stones[xStoneIdx] == 0) iterate = false;
		}
		
		return stones[yStoneIdx];
	}
	
	public static void merge(int[] arr) {
		int n = arr.length;
		int mid = n >> 1;
		int range = n - mid;
		
		int[] l = new int[mid];
		int[] r = new int[range];
		
		if(n > 1) {
			for(int i=0;i<mid;i++) l[i] = arr[i];
			for(int j=mid;j<n;j++) r[j-mid] = arr[j];
			
			merge(l);
			merge(r);
			
			int i=0,j=0,k=0;
			
			while(i < l.length && j < r.length) {
				if(l[i] <= r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,7,4,1,8,1};
		System.out.println(weight(A));
	}

}
