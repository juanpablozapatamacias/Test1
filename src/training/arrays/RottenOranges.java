package training.arrays;

import java.util.HashSet;
import java.util.Set;

public class RottenOranges {
	
	public static int orangesRotting(int[][] grid) {
		if(grid.length==0 || grid==null) return -1;
		
		Set<String> fresh = new HashSet<>();
		Set<String> rotten = new HashSet<>();
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 1) {
					fresh.add("" + i + j);
				}
				else if(grid[i][j] == 2) {
					rotten.add("" + i + j);
				}
			}
		}
		
		
		int mins = 0;
		int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};
		
		while(fresh.size() > 0) {
			Set<String> infected = new HashSet<>();
			for(String s : rotten) {
				int i = s.charAt(0) - '0';
				int j = s.charAt(1) - '0';
				
				for(int[] dir : direction) {
					int nextI = i + dir[0];
					int nextJ = j + dir[1];
					
					if(fresh.contains("" + nextI + nextJ)) {
						fresh.remove("" + nextI + nextJ);
						infected.add("" + nextI + nextJ);
					}
				}
			}
			
			if(infected.size() == 0) return -1;
			
			rotten = infected;
			mins++;
		}
		
		return mins;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(A));
	}

}
