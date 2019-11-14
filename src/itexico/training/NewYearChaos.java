package itexico.training;

public class NewYearChaos {

	public static int minimumBribes(int[] q) {
		int bribe = 0;
		boolean chaotic = false;
		
		for(int i=0;i<q.length;i++) {
			if(q[i] - (i+1) > 2) {
				chaotic = true;
				break;
			}
			for(int j=Math.max(0, q[i]-2);j<i;j++) {
				if(q[j] > q[i]) bribe++;
			}
		}
		if(chaotic) System.out.println("Too chaotic");
		else System.out.println(bribe);
		return bribe;
	}
	
	public static void main(String[] arg) {
		int [] ar = {2,5,1,3,4};
		int a = minimumBribes(ar);
	}
}
