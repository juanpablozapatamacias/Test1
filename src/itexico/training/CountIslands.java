package itexico.training;

public class CountIslands {
	public int numIslands(char[][] grid) {
		int total=0;
		int nRows = grid.length;
		int nCols = grid[0].length;
		
		boolean [][] visited = new boolean[nRows][nCols];
		
		/*for(boolean[] visRow : visited) {
			for(boolean visCol : visRow) {
				visCol = false;
			}
		}*/
		
		for (int i=0;i<nRows;i++) {
			for(int j=0;j<nCols;j++) {
				if(grid[i][j]=='1' && !visited[i][j]) {
					++total;
					findIslands(grid,visited,i,j);
				}
			}
		}
		
		return total;
	}
	
	public static void findIslands(char[][] grid, boolean visited[][], int a, int b) {
		try {
			if(grid[a][b] =='1' && !visited[a][b]) {
				visited[a][b]=true;
				
				//south
				if(a < grid.length - 1) {
					findIslands(grid,visited,a+1,b);
				}
				
				//east
				if(b < grid.length - 1) {
					findIslands(grid,visited,a,b+1);
				}
				
				//north
				if(a >= 1) {
					findIslands(grid,visited,a-1,b);
				}
				
				//south
				if(b >= 1) {
					findIslands(grid,visited,a,b-1);
				}
				
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
	}
	
	public static void main(String[] ar) {
		char[][] M = new char[][] {
								 {'0','1','1','0'},
								 {'0','1','0','0'},
								 {'1','0','1','1'}
								 };
								 
		CountIslands c = new CountIslands();
		System.out.println("El total de islas son: " + c.numIslands(M));
	} 

}
