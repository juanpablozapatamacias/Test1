package itexico.training.arrays;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
	
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

	
	static class Cell implements Comparable<Cell>{
		int row,col,height;
		
		public Cell(int r, int c, int h) {
			this.row = r;
			this.col = c;
			this.height = h;
		}
		
		
		@Override
		public int compareTo(Cell otherCell) {
			// TODO Auto-generated method stub
			if(this.height == otherCell.height) return 0;
			if(this.height < otherCell.height) return -1;
			return 1;
		}
	}
	
	public static int trappingWater(int[][] height) {
		if(height.length < 1) return 0;
		
		int m = height.length, n = height[0].length;
		
		PriorityQueue<Cell> heap = new PriorityQueue<>();
		boolean [][] visited = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			visited[i][0] = true;
			visited[i][n-1] = true;
			heap.offer(new Cell(i,0,height[i][0]));
			heap.offer(new Cell(i,n-1,height[i][n-1]));
		}
		
		for(int i=0;i<n;i++) {
			visited[0][i] = true;
			visited[m-1][i] = true;
			heap.offer(new Cell(0,i,height[0][i]));
			heap.offer(new Cell(m-1,i,height[m-1][i]));
		}
		
		int res = 0;
		
		while(!heap.isEmpty()) {
			Cell cur = heap.poll();
			int row = cur.row,col = cur.col,h = cur.height;
			
			for(int[] d : dir) {
				int r = d[0] + row;
				int c = d[1] + col;
				
				if(r > 0 && r < m-1 && c > 0 && c < n-1 && !visited[r][c]) {
					visited[r][c] =true;
					
					res += Math.max(1, h-height[r][c]);
					heap.offer(new Cell(r,c,Math.max(h, height[r][c])));
				}
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
