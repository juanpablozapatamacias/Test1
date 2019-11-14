package itexico.training;

import java.util.Arrays;
import java.util.Collections;

public class ElectronicsShop {
	
	public static int getMoneySpent(Integer[] keyboards, Integer[] drives,int b) {
		Arrays.sort(keyboards, Collections.reverseOrder());
		Arrays.sort(drives);
		
		int max = -1;
		
		for(int i=0,j=0;i<keyboards.length;i++) {
			for(;j<drives.length;j++) {
				if(keyboards[i] + drives[j] > b) break;
				if(keyboards[i] + drives[j] > max) 
					max=keyboards[i] + drives[j];
			}
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
	
		Integer[] kb = {4};
		Integer[] dr = {5};
		
		System.out.println(getMoneySpent(kb,dr,5));
	}

}
