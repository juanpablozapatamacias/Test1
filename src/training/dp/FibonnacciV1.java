package training.dp;

public class FibonnacciV1 {

	public static int fib(int n) {
		int[] cache = new int[n+1];
		
		// base cases
		cache[0] = 0;
		cache[1] = 1;
		
		for(int i=2;i<=n;i++) {
			cache[i]=cache[i-1]+cache[i-2];
		}
		
		return cache[n];
	}
	
	public static void main(String[] arg) {
		System.out.println(fib(10));
	}
}
