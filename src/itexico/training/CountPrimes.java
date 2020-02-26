package itexico.training;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
	
	public static int count(int n) {
		int count = 0;
		List<Integer> res = new ArrayList<>();
		
		boolean[] primes = new boolean[n];
				
		for(int i=2;i*i < primes.length;i++) {
			if(!primes[i]) {
				for(int j=i;j*i<primes.length;j++) {
					primes[i*j] = true;
				}
			}
		}
		
		for (int i=2;i<primes.length;i++) {
			if(!primes[i]) {
				count++;
				res.add(i);
			}
		}
		
		System.out.println(res.toString());
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(10));
	}

}
