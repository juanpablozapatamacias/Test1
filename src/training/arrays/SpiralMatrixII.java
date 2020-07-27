package training.arrays;

import java.util.Arrays;

public class SpiralMatrixII {
	
	public static int[][] spiral(int n){
		int [][] matrix = new int[n][n];
		
		int rowBegin = 0;
		int rowEnd = n-1;
		int colBegin = 0;
		int colEnd = n-1;
		
		int count=1;
		
		while(rowBegin <= rowEnd && colBegin<=colEnd) {
			for(int i=colBegin;i<=colEnd;i++) {
				matrix[rowBegin][i] = count++;
			}
			
			rowBegin++;
			
			for(int i=rowBegin;i<=rowEnd;i++) {
				matrix[i][colEnd]= count++;
			}
			
			colEnd--;
			
			if(rowBegin <= rowEnd) {
				for(int i=colEnd;i>=colBegin;i--) {
					matrix[rowEnd][i] = count++;
				}
			}
			
			rowEnd--;
			
			if(colBegin <= colEnd) {
				for(int i=rowEnd;i>=rowBegin;i--) {
					matrix[i][colBegin] =count++;
				}
			}
			
			colBegin++;
			
		}
		
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(spiral(3)));
	}

}
