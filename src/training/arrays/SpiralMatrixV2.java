package training.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixV2 {
	
	public static List<Integer> spiral(int[][] matrix){
		List<Integer> res = new ArrayList<>();
		
		if(matrix==null || matrix.length==0) return res;
		
		int top=0,down=matrix.length-1,left=0,right=matrix[0].length-1;
		
		//dir as 0 is right, dir as 1 is down, dir as 2 is left, dir as 3 is up
		int dir = 0; 
		
		while(top <= down && left<=right) {
			if(dir==0) {
				for(int i=left;i<=right;i++) {
					res.add(matrix[top][i]);
				}
				top++;
			}
			
			else if(dir==1) {
				for(int i=top;i<=down;i++) {
					res.add(matrix[i][right]);
				}
				right--;
			}
			
			else if(dir==2) {
				for(int i=right;i>=left;i--) {
					res.add(matrix[down][i]);
				}
				down--;
			}
			
			else if(dir==3) {
				for(int i=down;i>=top;i--) {
					res.add(matrix[i][left]);
				}
				left++;
			}
			
			dir=(dir+1) % 4;
		}
		
		return res;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(spiral(a));
	}

}
