package training;

public class ValidPalindromeNumber {
	
	public static boolean isValid(int x) {
		if(x==0) return true;
		if(x<=0 || x%10==0) return false;
		
		int reversed=0;
		while(x > reversed) {
			int pop = x%10;
			x/=10;
			reversed = (reversed *10) + pop;
		}
			
		return x == reversed || x==reversed /10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid(121));
	}

}
