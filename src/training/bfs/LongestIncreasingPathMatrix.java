package training.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathMatrix {

	public static int longest(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int m=matrix.length, n=matrix[0].length;
		int[][] graph = new int[m][n];
		int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
		
		for (int i=0;i<m;i++) {
			for(int j=0;j<n;j++){
				for(int[] d : dir) {
					int nR = i + d[0];
					int nC = j + d[1];
					
					if(nR<0 || nC<0 || nR==m || nC==n || matrix[i][j] <= matrix[nR][nC]) continue;
					graph[i][j]++;
				}
			}
		}
		
		Queue<int[]> qleaves = new LinkedList<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(graph[i][j] == 0) qleaves.offer(new int[]{i,j});
				
			}
		}
		
		int height = 0;
		
		while(!qleaves.isEmpty()) {
			height++;
			Queue<int[]> newQLeaves = new LinkedList<>();
			
			while(!qleaves.isEmpty()) {
				int[] leaf = qleaves.poll();
				
				for(int[] d : dir) {
					int nR = leaf[0] + d[0];
					int nC = leaf[1] + d[1];
					
					if(nR<0 || nC<0 || nR==m || nC==n || matrix[leaf[0]][leaf[1]] >= matrix[nR][nC]) continue;
					graph[nR][nC]--;
					
					if(graph[nR][nC] == 0) newQLeaves.offer(new int[] {nR,nC});
					
				}
			}
			qleaves =newQLeaves;
		}
		return height;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{9,9,4},{6,6,8},{2,1,1}};
		
		System.out.println(longest(A));
	}

}
