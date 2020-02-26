package itexico.training.arrays;

import java.util.Arrays;
import java.util.Collections;

public class RotateImage {

	public static void reverse(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		
		int[][] myArr = new int[rows][cols];
		
		for(int i=rows-1;i>=0;i--) {
			for(int j=cols-1;j>=0;j--) {
				myArr[rows-1-i][cols-1-i] = m[i][j];
			}
		}
	}
	
	public static void rotate(int[][] m) {
		//reverse(m);
		Collections.reverse(Arrays.asList(m));
		
		for(int i=0;i<m.length;++i) {
			for(int j=0;j<i;++j) {
				int temp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = temp;
				
			}
		}
	}
	
	public static void main(String[] a) {
		int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(Arrays.deepToString(m));
		rotate(m);
		System.out.println(Arrays.deepToString(m));
	}
}
