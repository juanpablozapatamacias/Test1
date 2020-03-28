package training.arrays;

public class ReverseWaveForm {

	public static void wavePrint(int[][] arr) {
		int i,j,wave=1;
		int m = arr.length;
		int n = arr[0].length;
		
		j = n-1;
		
		while (j>=0) {
			if(wave ==1) {
				for (i=0;i<m;i++)
					System.out.println(arr[i][j] + " ");
				
				wave = 0;
				j--;
			}
			else {
				for(i = m-1;i>=0;i--)
					System.out.println(arr[i][j] + " ");
				
				wave =1;
				j--;
			}
		}
	}
	
	public static void main(String[] arg) {
		int[][] A = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		wavePrint(A);
	}
}
