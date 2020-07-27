package training.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaIslandV2 {
	
	private static final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static int maxArea(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		
		for(int i=0; i<m; ++i) {
			for(int j=0;j<n;++j) {
				if(grid[i][j] == 0) 
					continue;
				
				int count = 0;
				Queue<int[]> q = new LinkedList<>();
				
				q.offer(new int[] {i,j});
				grid[i][j]=0;
				
				while(!q.isEmpty()) {
					int [] p = q.poll();
					res = Math.max(res, ++count);
					for(int[] dir : DIRS) {
						int r=p[0] + dir[0], c=p[1] + dir[1];
						if(r < 0 || r>=m ||c<0 || c>=n || grid[r][c] ==0) 
							continue;
						
						q.offer(new int[] {r,c});
						grid[r][c] = 0;
					}
				}
			}
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
	
		System.out.println(maxArea(a));
	}

}
