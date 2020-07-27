package training.arrays;

public class CountNegativeNumsSortedMatV2 {
	
	public static int count(int[][] grid) {
		int count =0;
		int total = grid.length * grid[0].length;
		
		for(int i=0;i<grid.length;i++) {
			
			//merge(grid[i]);
			
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][0] < 0) {
					i = grid.length;
					break;
				}
				if(grid[i][j] < 0) break;
				
				count++;
			}
		}
		
		return total - count;
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
				if(l[i] < r[j]) arr[k++] = l[i++];
				else arr[k++] = r[j++];
			}
			
			while(i < l.length) arr[k++] = l[i++];
			while(j < r.length) arr[k++] = r[j++];
		}
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{-1,2,3,4},{-3,-2,-1,1},{1,1,-1,-2},{-1,-1,-2,-3}};
		
		System.out.println(count(A));
	}

}
