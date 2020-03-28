package training.arrays;

public class RotateMatrix {
	
	public static int[][] rotateMatrix(int[][] m){
		if(m.length == 0) return new int[0][0];
		
		int rows = m.length;
		int cols = m[0].length;
		
		int [][] result = new int [cols][rows];
		
		for (int i=0;i<cols;i++) {
			for(int j=0;j<rows;j++) {
				result[i][j] = m[j][rows - i - 1];
			}
		}
		
		return result;
	}
	
	public static void printArray(int[][] A) {
		for (int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				System.out.print(A[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] B = rotateMatrix(A);
		
		printArray(B);
	}

}
