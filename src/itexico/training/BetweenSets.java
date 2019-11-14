package itexico.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetweenSets {
	static int getTotalX(List<Integer> a, List<Integer> b) {
		int ans = 0;
		int max = 1;
		int min = 101;
		boolean x,y;
		
		for (int i=max;i<=min;i++) {
			x = false;
			y = false;
			
			for(int j=0;j<a.size();j++) {
				if(i % a.get(j) == 0) x = true;
			}
			for(int k=0;k<b.size();k++) {
				if(b.get(k) % i == 0) y = true;
			}
			
			if(x && y) ans++;
		}
		
		return ans;
	}
	
	public static void main(String[] ar) {
		
		
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		a.add(2);
		a.add(4);
		
		b.add(16);
		b.add(32);
		b.add(96);
		
		System.out.println(getTotalX(a,b));
		
	}
	
}
