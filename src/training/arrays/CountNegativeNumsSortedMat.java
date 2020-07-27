package training.arrays;

public class CountNegativeNumsSortedMat {
	
	public static int count(int[][] grid) {
		int count = 0;
		int m = grid.length-1;
		int n = grid[0].length-1;
		
		for(int i=m;i>=0;i--) {
			for(int j=n;j>=0;j--) {
				if(grid[i][j] < 0) count++;
				else break;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		
		System.out.println(count(A));
	}

}
