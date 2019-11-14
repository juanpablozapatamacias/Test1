package itexico.training;

public class Digit {

	static int findDigit(int n) {
		int cp = n;
		int count = 0;
		
		while (cp > 0) {
			int digit = cp % 10;
			if(digit != 0 && n % digit == 0) count++;
			
			cp = cp / 10;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(findDigit(12));
		System.out.println(findDigit(1012));
		System.out.println(findDigit(111));
	}
}
