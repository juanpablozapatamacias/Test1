package training;

public class ValidSquare {
	
	public static boolean result(int num) {
		if(num < 0) return false;
		if(num <=1) return true;
		
		int i = 2;
		int j = num;
		
		while(i<=j) {
			int mid = i + (j-i) / 2;
			if(mid*mid == num) return true;
			else if(mid*mid > num) j = mid-1;
			else i = mid +1;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(result(16));
	}

}
