package training.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberIslands {
	
	public static int numIslands(char[][] grid) {
		if(grid.length == 0) return 0;
		
		int islands = 0;
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		for(boolean[] v : visited) 
			Arrays.fill(v, false);
		
		Queue<String> queue = new LinkedList<>();
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(!visited[i][j] && grid[i][j] == '1') {
					queue.add(i + "," +j);
					bfs(queue,grid,visited);
					islands++;
				}
			}
		}
		
		return islands;
	}
	

	private static void bfs(Queue<String> queue, char[][] grid, boolean[][] visited) {
		// TODO Auto-generated method stub
		int m = grid.length;
		int n= grid[0].length;
		
		while(!queue.isEmpty()) {
			String x = queue.remove();
			
			int row = Integer.parseInt(x.split(",")[0]);
			int col = Integer.parseInt(x.split(",")[1]);
			
			if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || grid[row][col] != '1')
				continue;
			
			visited[row][col] = true;
			
			queue.add(row + "," + (col-1));
			queue.add(row + "," + (col+1));
			queue.add((row+1) + "," + col);
			queue.add((row-1) + "," + col);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] M = new char[][] {
			 {'0','0','1','0'},
			 {'0','1','0','0'},
			 {'1','0','1','1'}
			 };
			 
		System.out.println(numIslands(M));
	}

}
