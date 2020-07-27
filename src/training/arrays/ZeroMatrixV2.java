package training.arrays;

import java.util.Arrays;

public class ZeroMatrixV2 {
	
	public static void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length==0 || matrix[0].length==0) return;
		
		int m = matrix.length, n=matrix[0].length;
		boolean firstRowZero = false, firstColumnZero=false;
		
		for(int j=0;j<n;++j) {
			if(matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			} 
		}
		
		for(int i=0;i<m;++i) {
			if(matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
		}
		
		for(int i=1;i<m;++i) {
			for(int j=1;j<n;++j) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i=1;i<m;++i) {
			for(int j=1;j<n;++j) {
				if(matrix[i][0] == 0 || matrix[0][j] ==0) {
					matrix[i][j] =0;
				} 
			}
		}
		
		if(firstRowZero) {
			for(int j=0;j<n;j++) {
				matrix[0][j] =0;
			}
		}
		
		if(firstColumnZero) {
			for(int i=0;i<m;++i) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		
		setZeroes(a);
		
		System.out.println(Arrays.deepToString(a));
	}

}
