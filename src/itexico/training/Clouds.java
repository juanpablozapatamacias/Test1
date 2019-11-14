package itexico.training;

public class Clouds {
	
	public static int jumpingClouds(int[] c) {
		
		int numJumps=0, i=0;
		while(i < c.length - 3) {
			i+= (c[i+2] == 0) ? 2 : 1;
			numJumps++;
		}
		numJumps++;
		
		return numJumps;
	}
	
	public static void main(String[] argv) {
		int[] c = {0,0,1,0,0,1,0};
		
		System.out.println(jumpingClouds(c));
	}
	
	

}
