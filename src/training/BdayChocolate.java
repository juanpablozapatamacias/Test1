package training;

import java.util.ArrayList;
import java.util.List;

public class BdayChocolate {
	
	static int getWays(int[] squares,int d, int m) {
		
		int ways=0;
		int sum=0;
		
		if(m <= squares.length)
			for(int i=0;i<m;i++) {
				sum+=squares[i];
			}
		
		if(sum == d) ways++;
		
		for(int i=0;i<squares.length-m;i++) {
			sum = sum -squares[i]+squares[i+m];
			if(sum == d) ways++;
		}
		
		return ways;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sq = new int[] {1,1,1,1,1,1};
		
		System.out.println(getWays(sq,3,2));

	}

}
