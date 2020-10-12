package training.dfs;

public class UniquePathsIII {
	
	static int totalPath =0;
	
	public static int uniquePaths(int[][] grid) {
		int totalZero = 0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 0) totalZero++; 
			}
		}
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 1) 
					dfs(grid,i,j,totalZero);
			}
		}
		
		return totalPath;
	}

	private static void dfs(int[][] grid, int i, int j, int totalZero) {
		// TODO Auto-generated method stub
		
		if(i<0 || j<0 || i>grid.length-1 || j>grid[i].length-1 ||grid[i][j] == -1  || 
				grid[i][j] == -99 || grid[i][j]==2 && totalZero!=0)
			return;
		
		if(grid[i][j] ==2 && totalZero == 0) totalPath++;
		if(grid[i][j] ==0) totalZero--;
		
		int temp = grid[i][j];
		
		grid[i][j] = -99;
		
		dfs(grid, i+1, j, totalZero);
		dfs(grid, i-1, j, totalZero);
		dfs(grid, i, j+1, totalZero);
		dfs(grid, i, j-1, totalZero);
		
		grid[i][j] = temp;
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
		
		System.out.println(uniquePaths(A));
	}

}
