package itexico.training.pilas.implementation;

import java.util.Stack;

public class GameStacks {
	
	public static int twoStacks(int x, int[] a, int[] b) {
		int j=0;
		int sum = 0;
		int maxScore = 0;
		
		/*
		 * First it performs a sum with all elements of array b
		 * O(N)
		 * */
		while(j < b.length && sum + b[j] <=x) {
			sum +=b[j];
			j++;
		}
		
		/*
		 * 
		 * After do the sum of all array b elements, we assign a maxscore with j index value of array b 
		 * 
		 * */
		maxScore = j;
		
		
		/*
		 * 
		 * Run another loop to add to the sum elements from array a, starting to the next index
		 * O(N^2) because of the nested loop
		 *  
		 * */
		for (int i=1;i<=a.length;i++) {
			sum += a[i-1];
			
			/*
			 * 
			 * validate if sum exceeded the limit and if array b index is zero
			 * 
			 * */
			while(sum > x && j >0) {
				j--;
				sum-=b[j];
			}
			
			if(sum > x) break;
			
			/*Get the maximum value between maxscore and the sum of arrays index*/
			maxScore = Math.max(maxScore, i+j);
		}
		
		return maxScore;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,2,4,6,1};
		int[] B = {2,1,8,5};
		int x = 10;
		
		System.out.println(twoStacks(x,A,B));
	}

}
