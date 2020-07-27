package training.arrays;

public class CountNegativeNumsSortedMatV3 {
	
	public static int count(int[][] grid) {
		int count =0;
		int i=0;
		int j = grid[0].length - 1;
		
		while(i < grid.length && j>=0) {
			if(grid[i][j] < 0) {
				count += grid.length-i;
				j--;
			}
			else 
				i++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		
		System.out.println(count(A));
	}

}
