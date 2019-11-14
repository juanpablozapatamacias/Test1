package itexico.training;

public class Paths {
	
	public static int numberOfPaths(int m, int n) {
		int[] dp = new int[n];
		
		dp[0]=1;
		
		for(int i=0;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[j] += dp[j-1];
				//System.out.print(dp[j] + " > ");
			}
		}
		
		return dp[n-1];
	}
	
	public static int numberOfPathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length==0) return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] ==1) return 0;
		
		int [][] dp = new int[m][n];
		
		dp[0][0] = 1;
		
		//left column
		for (int i=1;i<m;i++) {
			if(obstacleGrid[i][0] == 1)
				dp[i][0] = 0;
			else
				dp[i][0] = dp[i-1][0];
		}
		
		//top row
		for(int j=1;j<n;j++) {
			if(obstacleGrid[0][j] == 1)
				dp[0][j] = 0;
			else
				dp[0][j] = dp[0][j-1];
		}
		
		//fill rest of cells
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
		
	}
	
	public static void main(String[] arg) {
		System.out.println(numberOfPaths(2,3));
		System.out.println(numberOfPaths(7,3));
		
		int[][] arr1 = {{0,0,0,0,0},
						{0,1,0,1,0},
						{0,0,0,0,1},
						{1,0,0,0,0},
						{0,0,0,0,0}};
		
		System.out.println(numberOfPathsWithObstacles(arr1));
	}

}
