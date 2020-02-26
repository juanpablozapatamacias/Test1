package itexico.training;

public class PowerOfThree {

	public static boolean isPowOf3(int n) {
		if(n<=0) return false;
		else {
			while (n>1) {
				if(n % 3 != 0) return false;
				
				n/=3;
			}
		}
		
		return true;
	}
}
